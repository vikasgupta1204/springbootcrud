package com.api.book.bookrestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.book.bookrestbook.helper.FileUploadHelper;

@RestController
public class FileUploadController {
    @Autowired
    private FileUploadHelper fileUploadHelper;

    /*Multipart is used to handle the file coming from server */
    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("shivaji") MultipartFile file) {
        /* System.out.println(file.getOriginalFilename());
         System.out.println(file.getSize());
         System.out.println(file.getContentType());
         System.out.println(file.getResource());*/ 

        try{

        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
        }
        if(!file.getContentType().equals("image/jpeg")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG files are allowed");
        }

        /*File upload code */

        boolean f=fileUploadHelper.uploadFile(file);
        if(f){
            return ResponseEntity.ok("File is uploaded suceesfully");
        }
    }
    catch(Exception e){System.out.println("Exception occured in handler method");}
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong! Try again");
    }
}