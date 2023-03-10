package com.chat.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.application.model.Status;
import com.chat.application.repository.StatusRepository;

@Service
public class StatusService {

    @Autowired
    StatusRepository repository;


    public int saveStatus(Status status) {
        Status statusObj = repository.save(status);
        return statusObj.getStatusId();
    }
}