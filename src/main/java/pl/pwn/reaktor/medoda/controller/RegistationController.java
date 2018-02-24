
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
public class RegistationController {
	
	private UserService userService;
	
	@Autowired
	public RegistationController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/registration")
	private String registation(Model model) {
		
		model.addAttribute("user", new User());
		return("/registration");
	}
	
	@PostMapping("/register")
	public String save(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {

		}

		User savedUser = userService.addUserWithRoleUser(user);
		System.out.println("dodany: " + savedUser);

		model.addAttribute("status", "Rejestracja pomyślna!");
		model.addAttribute("user", new User());

		return "registration";

	}
	
	
	
}
