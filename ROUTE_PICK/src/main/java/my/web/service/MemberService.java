package my.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.web.dao.MemberDAO;
import my.web.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	MemberDAO memberDAO;
		
	public void memberInsert(MemberVO m) throws Exception{
		memberDAO.memberInsert(m);
	}

	public String login(MemberVO m) {
		return memberDAO.login(m);		
	}

	public void deleteMember(MemberVO m) {
		memberDAO.deleteMember(m);
	}

}


