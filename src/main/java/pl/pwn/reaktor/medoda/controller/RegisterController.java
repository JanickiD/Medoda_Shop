package pl.pwn.reaktor.medoda.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.pwn.reaktor.medoda.model.User;
import pl.pwn.reaktor.medoda.service.UserService;

@Controller
public class RegisterController {

	private UserService userService;
	
	@Autowired
	public RegistrationController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/registration")
	public String registration(Model model) {
		
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@PostMapping("/register")
	public String save(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		
		User savedUser = userService.addUserWithRoleUser(user);
		System.out.println("saved user: " + savedUser);
		model.addAttribute("success", "User has been registered successfully");
		model.addAttribute("user", new User());
		
		return "registration";
	}
}
