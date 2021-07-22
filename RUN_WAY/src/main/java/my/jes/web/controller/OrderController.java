package my.jes.web.controller;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import my.jes.web.service.OrderService;
import my.jes.web.vo.MemberVO;
import my.jes.web.vo.OrderVO;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

///////////// 주문 처리 //////////////////
	@RequestMapping(value = "order.jes", method = { RequestMethod.POST }, produces = "application/text; charset=utf8")

	public String order(HttpServletRequest request, HttpServletResponse response) {
		JSONObject json=new JSONObject();
		try {
			BufferedReader br=request.getReader();
			JSONParser parser=new JSONParser();
			JSONObject json2=(JSONObject) parser.parse(br);
			JSONArray array=(JSONArray) json2.get("product");
			
			Object [] array2=array.toArray();
			
			ArrayList<OrderVO> list=new ArrayList<OrderVO>();
			
			for(Object o: array2) {
				JSONObject j=(JSONObject)o;
				String prodname=(String) j.get("name");
				long quantity=(Long)j.get("quantity");//java5 unboxing
				
				OrderVO orderVO=new OrderVO("web",prodname,quantity);
				HttpSession session=request.getSession();
				MemberVO memberVO=(MemberVO) session.getAttribute("member");
				
				if(memberVO !=null) {
					orderVO.setMemberid(memberVO.getId());
				}else {
					orderVO.setMemberid("");
				}
				list.add(orderVO);
			}
			
			System.out.println("총 "+list.size()+"개 품목을 주문합니다");
			long order_group_no=orderService.ordersInsert(list);
			
			json.put("order_group_no", order_group_no);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			json.put("msg", e.getMessage());
		}
		
		return json.toJSONString();
	}
	
	  @PostMapping("local.jes")	
		public String login(HttpServletRequest request, HttpServletResponse response) {

			
			return orderService.local(request.getParameter("local"));
			

			
		}
}
