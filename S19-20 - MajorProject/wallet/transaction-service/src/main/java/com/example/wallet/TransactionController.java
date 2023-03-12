package com.example.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	
	@PostMapping("/transact")
	public String initiateTransaction(@RequestParam("receiver") String receiver,
			@RequestParam("purpose") String purpose,
			@RequestParam("amount") Double amount) throws JsonProcessingException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails user = (UserDetails) authentication.getPrincipal();
		
		return transactionService.initiateTransaction(user.getUsername(),receiver,purpose,amount);
	}

}
