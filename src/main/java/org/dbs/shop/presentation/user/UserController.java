package org.dbs.shop.presentation.user;

import java.util.List;

import org.dbs.shop.application.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Secured({ "ROLE_ADMIN" })
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;

	@GetMapping("admin/users")
	public ModelAndView showUsers() {
		final List<UserDTO> users = userMapper.mapToDtoList(userService.findAll());
		return new ModelAndView("users", "users", users);
	}

	@GetMapping("admin/userform")
	public ModelAndView showAddOrder(@ModelAttribute("userModel") final UserModel userModel) {

		return new ModelAndView("userform", "userModel", userModel);
	}

	@PostMapping("/addUser")
	public String addUser(final UserDTO userDto) {
		userService.registerNewUserAccount(userMapper.mapToDomain(userDto));
		return "redirect:/admin/users";
	}

}