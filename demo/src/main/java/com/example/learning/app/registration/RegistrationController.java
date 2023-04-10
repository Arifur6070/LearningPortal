package com.example.learning.app.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "api/v1/registration")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping
	public ResponseEntity<Object> register(@Valid@RequestBody RegistrationRequest request) {
//		return registrationService.register(request);

//		URI location = ServletUriComponentsBuilder.fromCurrentRequest();
		
		return new ResponseEntity<Object>(registrationService.register(request),HttpStatus.CREATED);
	
	}

}
