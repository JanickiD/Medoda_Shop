//package pl.pwn.reaktor.medoda.controller;
//
//import javax.validation.Valid;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import pl.pwn.reaktor.medoda.model.User;
//
//
//@Controller
//public class RegistationController {
//
//	@GetMapping("/registration")
//	private String registation() {
//		return("/registration");
//	}
//	
//	@PostMapping("/register")
//	public String save(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
//
//		if (bindingResult.hasErrors()) {
//
//		}
//
//		User savedUser = userService.addUserWithRole(user);
//		System.out.println("dodany: " + savedUser);
//
//		model.addAttribute("status", "Rejestracja pomyślna!");
//		model.addAttribute("user", new User());
//
//		return "registration";
//
//	}
//	
//	
//	
//}
