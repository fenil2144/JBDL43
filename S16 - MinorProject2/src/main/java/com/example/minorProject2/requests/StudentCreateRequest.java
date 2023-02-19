package com.example.minorProject2.requests;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.example.minorProject2.enums.AccountStatus;
import com.example.minorProject2.models.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class StudentCreateRequest {
	
	@NotBlank
	private String name;
	
	@Column(unique = true)
	private String email;
	
	@NotBlank
	private String contact;
	
	private String address;

	public Student toStudent() {
		return Student.builder()
				.address(address)
				.contact(contact)
				.email(email)
				.name(name)
				.accountStatus(AccountStatus.ACTIVE)
				.build();
	}
	

}
