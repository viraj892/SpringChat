package com.viraj.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.viraj.chat.MessageService;

@Controller
@SessionAttributes(value = "name")
public class WelcomeController {
	@Autowired
	MessageService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		model.put("name", service.getCurrentUsername(model));
		return "welcome";
	}

}
