package my.web.service;

import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import my.web.util.MyGetRequestor;

@Service
public class MashupService {
	
	//네이버 찾기
	public String local(String param) throws Exception {
		param = URLEncoder.encode(param, "UTF-8");
		param="query="+param+"&display=5";
		System.out.println(param);
		String urlString="https://openapi.naver.com/v1/search/local.json?"+param;
		
		return MyGetRequestor.request(urlString);
	}
	
	//네이버 길찾기 추후 수정 예정
	public String getDirections(String param) throws Exception {
		param = URLEncoder.encode(param, "UTF-8");
		param = "query" +param;
		String urlString="https://naveropenapi.apigw.ntruss.com/map-direction/"+param;
		
		return MyGetRequestor.request(urlString);
	}
	
}
