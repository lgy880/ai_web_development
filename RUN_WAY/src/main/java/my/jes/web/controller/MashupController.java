package my.jes.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import my.jes.web.service.MashupService;

@RestController
public class MashupController {
	
	@Autowired
	MashupService mashupService;
	
	@GetMapping("local.jes")
	public String local(HttpServletRequest request,HttpServletResponse response) {
		String local=request.getParameter("local");
		try {
			return mashupService.local(local);
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		}
		
	}

}
