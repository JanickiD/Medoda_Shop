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

import pl.pwn.reaktor.medoda.model.User;
import pl.pwn.reaktor.medoda.repository.RoleRepository;
import pl.pwn.reaktor.medoda.service.UserService;

@Controller
public class UserController {

	
	private UserService userService;
	private RoleRepository roleRepository;
	
	@Autowired
	public UserController(UserService userService, RoleRepository roleRepository) {
		super();
		this.userService = userService;
		this.roleRepository = roleRepository;
	}

	@GetMapping("admin/edit/{id}")
	public String edit(@PathVariable long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		model.addAttribute("roles", roleRepository.findAll());
		return "admin/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "admin/edit";
		}
		userService.editUser(user);
		return "redirect:/admin/"+user.getId();
	}
	
	@GetMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "admin/view";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		userService.delete(id);
		return "redirect:/admin/panel";
	}
	
	@PostMapping("/changePass")
	public String change(@Valid @ModelAttribute User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "admin/edit";
		}
		userService.changePass(user);
		return "redirect:/admin/view/"+user.getId();
	}

}
