package com.viraj.chat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.viraj.chat.Message;

@Service
public class MessageService {
	private static List<Message> messages = new ArrayList<Message>();
	private static int messageCount = 0;

	/*
	 * TODO
	 */
	public List<Message> getMessages() {
		return messages;
	}

	public void sendMessage(String user, String message) {
		messages.add(new Message(++messageCount, user, message));
	}

	public String getCurrentUsername(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}

	/*
	 * TODO
	 */
	public void deleteMessage(int id) {
		Iterator<Message> iterator = messages.iterator();
		while (iterator.hasNext()) {
			Message message = iterator.next();
			if (message.getId() == id) {
				iterator.remove();
			}
		}
	}
}
