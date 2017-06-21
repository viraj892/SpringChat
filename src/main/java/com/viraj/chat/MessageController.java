package com.viraj.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
		model.addAttribute("messages", service.getMessages());
		System.out.println(model.get("name"));
		return "show-chat";
	}

	@RequestMapping(value = "/send-message", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @RequestParam String message) {
		service.sendMessage("viraj", message);
		model.clear();
		return "redirect:/show-chat";
	}

}
