package my.jes.web.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import my.jes.web.dao.OrderDAO;
import my.jes.web.vo.OrderVO;

@Service
public class OrderService {
	@Autowired
	OrderDAO orderDAO;

	public long ordersInsert(ArrayList<OrderVO> list) throws Exception {
		return orderDAO.ordersInsert(list);
	}

	public String local(String local) {
		String clientId = "IwbsN3GYZlFFA8NOBgLL";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "AOoNNhG1i1";// 애플리케이션 클라이언트 시크릿값";
		try {
			String text = URLEncoder.encode(local, "UTF-8");
			String getParams = "query=" + text + "&display=10&start=1";
			String apiURL = "https://openapi.naver.com/v1/search/local.json?" + getParams;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			return response.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
