package com.mindfulqatar.jobportal.services;

import java.util.List;

import com.mindfulqatar.jobportal.entities.Message;

public interface MessageService {
	void saveMessage(Message message);

	List<Message> getAllMessages();
}
