package pl.pwn.reaktor.medoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.pwn.reaktor.medoda.model.User;
import pl.pwn.reaktor.medoda.service.UserService;

@Controller
public class PanelController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/panel")
	private String panel(Model model, Pageable pageable) {
		Page<User> pageUser = userService.getAll(pageable);
		model.addAttribute("users", pageUser);
		PageWrapper<User> page = new PageWrapper<>(pageUser, "/panel");
		model.addAttribute("page", page);
		return "admin/panel";
	}

}
