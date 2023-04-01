package com.examplecrud.demojsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class DemojspApplication {
        @RequestMapping("/")
        public String hello(Model model){
            return "../authorization/login";
        }
	public static void main(String[] args) {
		SpringApplication.run(DemojspApplication.class, args);
	}

}
