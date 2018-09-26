package com.example.phoenix_01;

import com.example.phoenix_01.service.JsonToCsv;


import com.example.phoenix_01.util.AcquireJson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class Application {

    @RequestMapping(value = "/hello")
	public String index(){
		return "hello";
	}

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
}
