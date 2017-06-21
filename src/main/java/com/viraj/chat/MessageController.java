package com.viraj.chat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.viraj.chat.MessageService;

@Controller
@SessionAttributes("name")
public class MessageController {

	@Autowired
	private MessageService service;

	@RequestMapping(value = "/show-chat", method = RequestMethod.GET)
	public String showChat(ModelMap model) {
		model.addAttribute("message", new Message(0, (String) model.get("name"), ""));
		model.addAttribute("messages", service.getMessages());
		return "show-chat";
	}

	@RequestMapping(value = "/send-message", method = RequestMethod.POST)
	public String send(ModelMap model, @Valid Message message, BindingResult result) {
		if (result.hasErrors()) {
			return "show-chat";
		}

		service.sendMessage((String) model.get("name"), message.getMessage());
		model.clear();
		return "redirect:/show-chat";
	}

	private String getCurrentUsername(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}

}
