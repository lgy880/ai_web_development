package my.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import my.web.service.MashupService;

@RestController
public class MashupController {
	
	@Autowired
	MashupService mashupService;
	
	@GetMapping("local.rp")
	public String local(HttpServletRequest request, HttpServletResponse response){
		
		String local=request.getParameter("local");
		try {
			return mashupService.local(local);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@GetMapping("getDirections.rp")
	public String getDirections(HttpServletRequest request, HttpServletResponse response){
		
		String directions=request.getParameter("getDirections");
		try {
			return mashupService.getDirections(directions);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	

}
