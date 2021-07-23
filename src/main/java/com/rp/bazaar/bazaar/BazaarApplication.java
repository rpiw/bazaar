package com.rp.bazaar.bazaar;

import com.rp.bazaar.bazaar.scrapper.MainPageExporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@SpringBootApplication
//@RestController
public class BazaarApplication {
	private static final Logger logger = LoggerFactory.getLogger(BazaarApplication.class);
	public static void main(String[] args) {
		var mainPageRecord = MainPageExporter.getMainPage();
		logger.debug("Main page meta data is {}", mainPageRecord);
//		SpringApplication.run(BazaarApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

}