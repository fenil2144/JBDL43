package com.example.startProject.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class Demo implements Serializable {
	
	private int id;
	private String name;
	private String phone;
	
}
