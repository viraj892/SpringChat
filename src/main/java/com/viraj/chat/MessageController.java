package com.viraj.chat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.viraj.chat.MessageService;

/**
 * 
 * @author Viraj Shah
 *
 */
@Controller
@SessionAttributes("name")
public class MessageController {

	@Autowired
	private MessageService service;

	/**
	 * Navigational endpoint for show-chat.jsp page
	 * 
	 * @param model
	 *            ModelMap mapping field data from the frontend
	 * @return jsp page show-chat.jsp
	 */
	@RequestMapping(value = "/show-chat", method = RequestMethod.GET)
	public String showChat(ModelMap model) {
		model.addAttribute("message", new Message(0, (String) model.get("name"), ""));
		model.addAttribute("messages", service.getMessages());
		return "show-chat";
	}

	/**
	 * 
	 * @param model
	 *            ModelMap mapping field data from the frontend
	 * @param message
	 *            Binding variable
	 * @param result
	 *            refresh show-chat.jsp with new message
	 * @return
	 */
	@RequestMapping(value = "/send-message", method = RequestMethod.POST)
	public String send(ModelMap model, @Valid Message message, BindingResult result) {
		if (result.hasErrors()) {
			return "show-chat";
		}

		service.sendMessage(service.getCurrentUsername(model), message.getMessage());
		model.clear();
		return "redirect:/show-chat";
	}

}
