package com.mindfulqatar.jobportal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindfulqatar.jobportal.entities.Message;
import com.mindfulqatar.jobportal.repositories.MessageRepository;
import com.mindfulqatar.jobportal.services.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageRepository repoMessage;

	@Override
	public void saveMessage(Message message) {
		repoMessage.save(message);
	}

	@Override
	public List<Message> getAllMessages() {
		return repoMessage.findAll();
	}
}
