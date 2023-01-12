package com.api.book.bootrestbook.controllers;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.bootrestbook.filehelper.FileUploadHelper;

@RestController
public class FileUploadController {
    
    @Autowired
   private FileUploadHelper  fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
    {
        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        // System.out.println(file.getContentType());
        // System.out.println(file.getName());

        //validation...

            try {
                
                if(file.isEmpty())
                {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File Is Not Selected....");
                }

                // if(!file.getContentType().equals("image/jpeg"))
                // {
                //     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG File ");

                // }

                //file upload file
                boolean uploaded=fileUploadHelper.uploadFile(file);
                if(uploaded)
                {
                    // return ResponseEntity.ok("File is Sucessfully uploaded..");

                    return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
                }

            } catch (Exception e) {

                    e.printStackTrace();

            }

        

         
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Somthing went wrong ! try again");
    }


}
