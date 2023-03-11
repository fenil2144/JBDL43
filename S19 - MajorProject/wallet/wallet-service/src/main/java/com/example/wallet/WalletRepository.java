package com.example.wallet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer>{
	Wallet findByPhoneNumber(String phoneNumber);
}
