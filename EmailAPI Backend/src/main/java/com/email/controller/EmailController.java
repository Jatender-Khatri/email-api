package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.Email;
import com.email.model.EmailResponse;
import com.email.service.EmailService;

@RestController
@CrossOrigin
public class EmailController {
	@Autowired
	private EmailService emailService;
	@RequestMapping("/welcome")
	public String welcome()
	{
		return "This is the Email API";
	}
	@PostMapping("/sendEmail")
	public ResponseEntity<?> sendEmail(@RequestBody Email email)
	{
		boolean result = this.emailService.sendEmail(email.getSubject(), email.getMessage(), email.getTo());
		if(result)
		{
			return ResponseEntity.ok(new EmailResponse("Email Send Successfully.."));
		}
		else {
			return ResponseEntity.ok(new EmailResponse("Error Occure In Controller"));
		}
		
	}
}
