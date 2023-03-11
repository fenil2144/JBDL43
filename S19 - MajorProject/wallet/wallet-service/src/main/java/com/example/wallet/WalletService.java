package com.example.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
	
	@Autowired
	WalletRepository walletRepository;
	
	public void createWallet() {
		Long userId;
		Wallet wallet = Wallet.builder()
				.userId(userId)
				.phoneNumber()
				.userIdentifier()
				.identifierValue()
				.balance()
				.build();
		
		walletRepository.save(wallet);
	}

}
