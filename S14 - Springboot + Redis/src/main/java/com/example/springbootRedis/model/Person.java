package com.example.springbootRedis.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable{
	
	private long id;
	private String name;
	private int age;
	private double creditScore;

}
