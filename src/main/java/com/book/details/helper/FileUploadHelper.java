package com.book.details.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	//static
//	public final String UPLOAD_DIR="C:\\Users\\DELL\\Documents\\workspace-spring-tool-suite-4-4.15.1.RELEASE\\RestApiForBooksDetail\\src\\main\\resources\\static\\images";

	//dynamic
	public final String UPLOAD_DIR = new ClassPathResource("static/images").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException {
		
	}
	
	public boolean uploadFile(MultipartFile file) {
		boolean flag = false;
		
		try {
//			InputStream is = file.getInputStream();
//			byte[] data = new byte[is.available()];
//			is.read(data);
//			
//			//write
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + File.separator + file.getOriginalFilename());
//			fos.write(data);
//			
//			fos.flush();
//			fos.close();
//			
//			flag = true;
			
			
			//We can also do this
			Files.copy(file.getInputStream(), 
					Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()), 
					StandardCopyOption.REPLACE_EXISTING);
			flag = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
}
