package pl.pwn.reaktor.medoda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/index")
	private String index() {
		return("index");
	}
	
	@GetMapping("/")
	private String index2() {
		return("index");
	}
}
