package com.spring.cm.contactmanager.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.standard.inline.StandardCSSInliner;

import com.spring.cm.contactmanager.dao.ContactRepository;
import com.spring.cm.contactmanager.dao.UserRepository;
import com.spring.cm.contactmanager.entities.Contact;
import com.spring.cm.contactmanager.entities.User;
import com.spring.cm.contactmanager.helper.Message;

import antlr.StringUtils;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping("/index")
    public String dashboard(Model model,Principal principal){
        model.addAttribute("title", "User Dashboard");
        return "normal/user_dashboard";
    }
    /*open add form controller */
    @RequestMapping("/add-contact")
    public String openAddContactForm(Model model){
        model.addAttribute("title", "Add Contact");
        model.addAttribute("contact", new Contact());
        return "normal/add_contact_form";
    }

    @ModelAttribute
    public void addCommonData(Model model,Principal principal){
        String userName=principal.getName();
        System.out.println("USERNAME: "+userName);
        User user=userRepository.getUserByUserName(userName);
        System.out.println("USER ->"+user);
        model.addAttribute("user", user);
    }
    //processing add contact form
    /*Principal is used to fetch the user details who is logged in and multipart is used to store the image file */
    @PostMapping("/process-contact")
    public String processContact(@ModelAttribute Contact contact,@RequestParam("profileImage") MultipartFile file, Principal principal,HttpSession session){
        try{
        String name=principal.getName();
       User user= this.userRepository.getUserByUserName(name);
       contact.setUser(user);
       /*Processing and uploading file */
       if(file.isEmpty()){
        /*if the file is empty then try our message */
        System.out.println("file is empty");
        contact.setImagepath("contact.png");
       }
       else{
            // /*Upload the file to folder and update the contact */
            contact.setImagepath(file.getOriginalFilename());
             File savefile=new ClassPathResource("static/image").getFile();
             Path path=Paths.get(savefile.getAbsolutePath()+File.separator+file.getOriginalFilename());
             Files.copy(file.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
             System.out.println("Image is uploaded");
        
            
       }
       user.getContacts().add(contact);
       this.userRepository.save(user);
        System.out.println("DATA:"+contact);
        System.out.println("Added to database");
        /*message success */
        session.setAttribute("message", new Message("Your contact is added! Add more","success"));
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
            e.printStackTrace();
            /*error message */
            session.setAttribute("message",new Message("Something went wrong! Try again", "danger"));
        }
        return "normal/add_contact_form";
    }

    //show contacts handler
    @GetMapping("/show-contacts/{page}")
    public String showContacts(@PathVariable("page") Integer page, Model model,Principal principal){
        model.addAttribute("title","Show User Contacts");
        String userName=principal.getName();
        User user=this.userRepository.getUserByUserName(userName);
        Pageable pageable= PageRequest.of(page, 3);
        Page<Contact> contacts=this.contactRepository.findContactByUser(user.getId(),pageable);
        model.addAttribute("contacts",contacts);
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",contacts.getTotalPages());
        /*send contact list to view
        String username=principal.getName();
        User user=this.userRepository.getUserByUserName(username);
       List<Contact> contacts= user.getContacts();*/
        return "normal/show_contacts";
    }

    //display contact details
    @GetMapping("/contact/{cid}")
    public String showContactDetails(@PathVariable("cid") Integer cid,Model model,Principal principal){
        System.out.println("CID->"+cid);
        Optional<Contact> contactOptional=this.contactRepository.findById(cid);
        Contact contact=contactOptional.get();

        String userName=principal.getName();
        User user=this.userRepository.getUserByUserName(userName);
        if(user.getId()==contact.getUser().getId()){
        model.addAttribute("contact", contact);
        model.addAttribute("title", contact.getName());
    }
        return "normal/contact_detail";
    }
    //delete contact handler
    @GetMapping("/delete/{cid}")
    public String deleteContact(@PathVariable("cid") Integer cid,Model model,HttpSession session){

        Optional<Contact> contactOptional=this.contactRepository.findById(cid);
        Contact contact=contactOptional.get();
        contact.setUser(null);
        Contact updatedContact=this.contactRepository.save(contact);
        //check
        System.out.println(updatedContact);
        this.contactRepository.delete(updatedContact);
        System.out.println("DELETED");
        session.setAttribute("message", new Message("Contact deleted successfully","success"));
        return "redirect:/user/show-contacts/0";
    }


    //open update form handler
    @PostMapping("/update-contact/{cid}")
    public String updateForm(@PathVariable("cid") Integer cid,Model m){
        m.addAttribute("title", "Update Contact");
        Contact contact=this.contactRepository.findById(cid).get();
        m.addAttribute("contact", contact);
        return "normal/update_form";
    }

    //update contact handler
    @RequestMapping(value="/process-update",method=RequestMethod.POST)
    public String updateHandler(@ModelAttribute Contact contact,@RequestParam("profileImage") MultipartFile file,Model m ,HttpSession session,Principal principal){
        try {
            //old contact detail
            Contact oldContactDetail=this.contactRepository.findById(contact.getCid()).get();
            if(!file.isEmpty()){
                //file work
                //rewrite   
                //delete old photo
                File deleteFile=new ClassPathResource("static/img").getFile();
                File file1=new File(deleteFile,oldContactDetail.getImagepath());
                file1.delete();

                //upload new photo
                File savefile=new ClassPathResource("static/image").getFile();
                Path path=Paths.get(savefile.getAbsolutePath()+File.separator+file.getOriginalFilename());
                Files.copy(file.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
                contact.setImagepath(file.getOriginalFilename());
            }
            else{
                contact.setImagepath(oldContactDetail.getImagepath());
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        User user=this.userRepository.getUserByUserName(principal.getName());
        contact.setUser(user);
        this.contactRepository.save(contact);
        session.setAttribute("message", new Message("Your contact is updated...","......."));

        System.out.println("CONTACT NAME "+contact.getName());
        System.out.println("CONTACT ID "+contact.getCid());
        return "redirect:/user/contact/"+contact.getCid();
    }
}   