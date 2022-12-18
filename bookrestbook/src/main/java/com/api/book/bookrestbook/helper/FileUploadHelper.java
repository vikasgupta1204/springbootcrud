package com.api.book.bookrestbook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    //public final String UPLOAD_DIR="F:\\Language Module\\Java\\springbootpractice\\bookrestbook\\src\\main\\resources\\static";
    public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();
    
    public FileUploadHelper() throws IOException{}
    public boolean uploadFile(MultipartFile multipartFile){

        System.out.println(UPLOAD_DIR);
        boolean f=false;
        // try{
        //     InputStream is=multipartFile.getInputStream();
        //     byte[] data=new byte[is.available()];
        //     is.read(data);
        
        //     //to write data on file
        //     FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
        //     fos.write(data);
        //     fos.flush();
        //     fos.close();
        //     is.close();;
        //     f=true;
        // }
        // catch(Exception e){}

        /*Copying file to project folder in single line using nio package */
        try {
            System.out.println("Copying file");
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f=true;
        } catch (IOException e) {
            System.out.println("File copy not successful");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return f;
    }
}