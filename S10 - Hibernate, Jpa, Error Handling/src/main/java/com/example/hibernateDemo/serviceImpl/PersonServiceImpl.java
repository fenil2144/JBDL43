package com.example.hibernateDemo.serviceImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernateDemo.dtos.CreatePersonDto;
import com.example.hibernateDemo.exception.PersonNotFoundException;
import com.example.hibernateDemo.model.Person;
import com.example.hibernateDemo.repository.PersonRepositoryInterf;
import com.example.hibernateDemo.service.PersonServicfeInterf;


@Service
public class PersonServiceImpl implements PersonServicfeInterf{
	
	@Autowired
	PersonRepositoryInterf personRepositoryInterf;

	@Override
	public void createPersonStatic(CreatePersonDto createPersonDto) {
		Person person = createPersonDto.to();
		
		if(person.getAge() == null)
			person.setAge(calculateAgeFromDOB(person.getDob()));
		personRepositoryInterf.save(person);		
	}
	
	private Integer calculateAgeFromDOB(String dob) {
		if(dob == null) {
			return null;
		}
		LocalDate dobDate = LocalDate.parse(dob);
		LocalDate currentDate = LocalDate.now();
		
		return Period.between(dobDate, currentDate).getYears();

	}

	@Override
	public Person getPersonById(int id) {
		return personRepositoryInterf.findById(id).orElseThrow(
				() -> new PersonNotFoundException("person with Id "+id+" not Present!"));
	}

	@Override
	public void deletePerson(int id) {
		personRepositoryInterf.deleteById(id);
	}

	@Override
	public List<Person> getAllPersons() throws SQLException {
		return personRepositoryInterf.findAll();
	}


}
