package my.jes.web.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import my.jes.web.util.MyGetRequestor;

@Service
public class MashupService {
	
	public String local(String param) throws Exception {
		param = URLEncoder.encode(param, "UTF-8");
		param="query="+param+"&display=5";
		System.out.println(param);
		String urlString="https://openapi.naver.com/v1/search/local.json?"+param;
		
		return MyGetRequestor.request(urlString);
	}

}
