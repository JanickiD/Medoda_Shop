package pl.pwn.reaktor.medoda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

	@GetMapping("/product")
	private String product() {
		return("product");
	}
}
