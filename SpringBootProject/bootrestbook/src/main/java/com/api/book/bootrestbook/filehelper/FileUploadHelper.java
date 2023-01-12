package com.api.book.bootrestbook.filehelper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
   
 //Ststic path    
// public final String UPLOAD_DIR="/home/rajukumar/Desktop/SpringBootProject/bootrestbook/src/main/resources/static/image";

//dynamic path set
public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();




public FileUploadHelper()throws IOException {
}




public boolean uploadFile(MultipartFile  multipartFile)
{
    boolean file=false;
    try {
            // InputStream inputStream=multipartFile.getInputStream();

            // byte data[]=new byte[inputStream.available()];
            // inputStream.read(data);

            // //write
            // FileOutputStream fileOutputStream=new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
            // fileOutputStream.write(data);
            // fileOutputStream.flush();
            // fileOutputStream.close();

            Files.copy(multipartFile.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING);

            file=true;
    } catch (Exception e) {
     e.printStackTrace();

    }
    return file;
}

}
