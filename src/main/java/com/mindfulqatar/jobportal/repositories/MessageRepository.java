package com.mindfulqatar.jobportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindfulqatar.jobportal.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
