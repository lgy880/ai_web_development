package my.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import my.web.service.MemberService;
import my.web.vo.MemberVO;

@RestController
public class HomeController {
	
	@Autowired MemberService memberService;
	
	@PostMapping("login.rp")
	public MemberVO login(@ModelAttribute("info") MemberVO m, HttpServletRequest request, HttpServletResponse response){
		
		try {
			String name=memberService.login(m);
			if(name!=null) {
				HttpSession session=request.getSession();
				session.setAttribute("member", m);
				m.setName(name);
			}else {
				m=new MemberVO();
			}
		}catch(Exception e) {
			m=new MemberVO();
		}		
		return m;

	}
	
	@RequestMapping(value = "memberInsert.rp", 
			method= {RequestMethod.POST},
			produces = "application/text; charset=utf8")
			
	public String memberInsert(@RequestParam("id") String id,
			@RequestParam("pw") String pw, @RequestParam(value="name", required = false) String name,
			HttpServletRequest request, HttpServletResponse response){			
		
		try {
			MemberVO m = new MemberVO(id,pw, name);
			memberService.memberInsert(m);
			return name+"님 회원가입되셨습니다";
		}catch(Exception e){
			return e.getMessage();
		}
	}
	
	@RequestMapping(value = "logout.rp", 
			method= {RequestMethod.POST},
			produces = "application/text; charset=utf8")			
	public String logout(HttpServletRequest request,
			HttpServletResponse response){
		
			HttpSession session=request.getSession(false);
			session.invalidate();
			return "";
		
	}

	@RequestMapping(value = "memberDelete.rp", 
			method= {RequestMethod.POST},
			produces = "application/text; charset=utf8")			
	public String delete(HttpServletRequest request,
			HttpServletResponse response){
		
			HttpSession session=request.getSession(false);
			MemberVO m = (MemberVO) session.getAttribute("member");
			
			memberService.deleteMember(m);
			session.invalidate();
			return "";
		
	}
		
	


} 
