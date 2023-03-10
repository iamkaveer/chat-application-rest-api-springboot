package com.chat.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chat.application.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

}
