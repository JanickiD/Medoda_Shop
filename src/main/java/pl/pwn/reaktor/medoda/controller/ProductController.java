package pl.pwn.reaktor.medoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pl.pwn.reaktor.medoda.service.ProductService;


@Controller
public class ProductController {
private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}


	@GetMapping("/product")
	private String product(Model model) {

		model.addAttribute("products", productService.listAllProducts());
		return "product";
	}
	
	
	@GetMapping("{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("product", productService.findById(id));
		model.addAttribute("products",productService.listAllProducts());
		return "view";
	}
	
	
}
