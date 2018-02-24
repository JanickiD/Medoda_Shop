
package pl.pwn.reaktor.medoda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author user
 *
 */
@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

}
