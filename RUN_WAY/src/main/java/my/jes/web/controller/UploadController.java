package my.jes.web.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
	
	@PostMapping("upload.jes")
	public String upload(@RequestParam("myFile") MultipartFile file) {	
		System.out.println(file);
		try {
			file.transferTo(new File("c:\\temp\\"+file.getOriginalFilename()));
		} catch (Exception e) {			
			e.printStackTrace();
			return "upload fail";
		} 
		return "upload ok";
	}
}
