package cn.takujo.demo;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@SpringBootApplication
public class DemoApplication {

	@Autowired
	private RestTemplate rTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		try {
			var ia = InetAddress.getLocalHost();
			var hn=ia.getHostName();
			return hn;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	@RequestMapping("/call")
	@ResponseBody
	public String call() {
		try {
			var resp=rTemplate.getForObject("http://ads.ads:8080/abc", String.class);
			return resp;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}
