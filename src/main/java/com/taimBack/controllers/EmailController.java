package com.taimBack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taimBack.config.EmailService;
import com.taimBack.entities.Email;

@RestController
@RequestMapping("/email")
public class EmailController {

	    @Autowired
	    private EmailService emailService;

	    @PostMapping("/send")
	    public String sendEmail(@RequestBody Email emailRequest) {
	        emailService.sendSimpleEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
	        return "Email sent successfully";
	    }
	

}
