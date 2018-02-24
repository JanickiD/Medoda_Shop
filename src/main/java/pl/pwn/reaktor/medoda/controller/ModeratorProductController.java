package pl.pwn.reaktor.medoda.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pl.pwn.reaktor.medoda.model.Product;
import pl.pwn.reaktor.medoda.service.ProductService;

@Controller
public class ModeratorProductController{
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/panelMod")
	private String panel(Model model) {
		model.addAttribute("products",productService.listAllProducts());
		return "panelMod";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable long id, Model model) {

		model.addAttribute("product", productService.findById(id));
		
		return "moderator/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "moderator/edit";
		}

		productService.editProduct(product);
		return "redirect:/moderator/" + product.getId();
	}

	
	

}
