package com.viraj.registration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.viraj.dao.User;
import com.viraj.dao.UserService;

@Controller
public class RegistrationController {
	@Autowired
	private UserService service;

	/**
	 * Navigational endpoint for registration page
	 * 
	 * @param model
	 *            ModelMap mapping registration details from the frontend
	 * @return redirection to register.jsp
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationPage(ModelMap model) {
		model.addAttribute("user", new User(0, "", "", ""));
		return "register";
	}

	/**
	 * 
	 * @param model
	 *            ModelMap mapping registration details from the frontend
	 * @param user
	 *            Command Object mapped to frontend
	 * @return Failure page if unsuccessful login else, success page
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(ModelMap model, User user) throws Exception {

		List<User> allUsers = service.getAllUsers();

		// Checking if user already exists
		for (User u : allUsers)
			if (user.getUsername().equals(u.getUsername()) || user.getEmail().equalsIgnoreCase(u.getEmail()))
				return "reg-failure";
		// List<GrantedAuthority> authorities = new
		// ArrayList<GrantedAuthority>();
		// authorities.add(new SimpleGrantedAuthority("USER"));
		// authorities.add(new SimpleGrantedAuthority("ADMIN"));
		//
		service.addUser(user);
		// service.setUserDetails(new
		// org.springframework.security.core.userdetails.User(user.getUsername(),
		// user.getPassword(), authorities));

		// Authentication authentication = new
		// UsernamePasswordAuthenticationToken(service.getUserDetails(),
		// service.getUserDetails().getPassword(),
		// service.getUserDetails().getAuthorities());
		// SecurityContextHolder.getContext().setAuthentication(authentication);
		// System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString());

		return "reg-success";
	}
}
