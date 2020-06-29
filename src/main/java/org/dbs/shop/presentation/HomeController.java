package org.dbs.shop.presentation;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
public class HomeController {

	@GetMapping("/home")
	public String home(final Model model) {
		return "userhome";
	}

}
