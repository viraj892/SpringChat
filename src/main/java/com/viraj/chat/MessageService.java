package com.viraj.chat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.viraj.chat.Message;

@Service
public class MessageService {
	private static List<Message> messages = new ArrayList<Message>();
	private static int messageCount = 3;
 
	static {
		messages.add(new Message(1, "viraj", "Hi"));
		messages.add(new Message(2, "kaushik", "hello"));
		messages.add(new Message(3, "cletus", "Hey!"));
	}

	/*
	 * TODO
	 */
	public List<Message> getMessages() {
		return messages;
	}

	public void sendMessage(String user, String message) {
		messages.add(new Message(++messageCount, user, message));
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
