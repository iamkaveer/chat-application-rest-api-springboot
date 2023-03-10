package com.chat.application.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.application.model.Status;
import com.chat.application.service.StatusService;

@RestController
@RequestMapping
public class StatusController {

    @Autowired
    StatusService service;

    //creat a new status
    @PostMapping("/create-status")
    public ResponseEntity<String> createStatus(@RequestBody String statusData) {
        Status status = setStatus(statusData);
        int statusId = service.saveStatus(status);
        return new ResponseEntity<>("status saved- " + statusId, HttpStatus.CREATED);
    }

    //method to set status
    private Status setStatus(String statusData) {
        //Create new status object
        Status status = new Status();
        JSONObject json = new JSONObject(statusData);
        String statusName = json.getString("statusName");
        String statusDescription = json.getString("statusDescription");
        status.setStatusName(statusName);
        status.setStatusDescription(statusDescription);
        return status;
    }

}