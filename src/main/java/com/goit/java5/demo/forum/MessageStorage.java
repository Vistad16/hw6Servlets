package com.goit.java5.demo.forum;

import java.util.List;

public interface MessageStorage {
	List<Message> getAllMessages();
	void add(Message message);
	void deleteById(String id);
}
