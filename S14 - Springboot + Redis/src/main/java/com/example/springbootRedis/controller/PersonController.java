package com.example.springbootRedis.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootRedis.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class PersonController {
	
	private static final String PERSON_KEY_PREFIX = "per::";
	private static final String PERSON_LIST_KEY_PREFIX = "per_list::";
	private static final String PERSON_HASH_KEY_PREFIX = "per_hash::";
	
	
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	ObjectMapper objectMapper;
	
	//String Operation(Key - String, Value - person)
	@PostMapping("/person")
	public void savePerson(@RequestBody Person person) {
		String key = getKey(person.getId());
		redisTemplate.opsForValue().set(key, person);
	}
	
	@GetMapping("/person")
	public Person getPerson(@RequestParam("id") long id) {
		String key = getKey(id);
		return (Person) redisTemplate.opsForValue().get(key);
	}
	
	private String getKey(long id) {
		return PERSON_KEY_PREFIX+id;
	}
	
	//List Operations(Key - String, Value - List<Person>)
	@PostMapping("/lpush/person")
	public void lpush(@RequestBody List<Person> personList) {
		
		for(Person person : personList) {
			redisTemplate.opsForList().leftPush(PERSON_LIST_KEY_PREFIX, person);
		}

	}
	
	@PostMapping("/rpush/person")
	public void rpush(@RequestBody List<Person> personList) {
		redisTemplate.opsForList().rightPushAll(PERSON_LIST_KEY_PREFIX, personList);
	}
	
	@DeleteMapping("/lpop/person")
	public Person lpop() {
		return (Person) redisTemplate.opsForList().leftPop(PERSON_LIST_KEY_PREFIX);
	}
	
	@DeleteMapping("/rpop/person")
	public List<Person> rpop(@RequestParam(value="count",required = false,defaultValue = "1") int count) {
		return redisTemplate.opsForList().rightPop(PERSON_LIST_KEY_PREFIX,count)
				.stream().map(x -> (Person)x)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/lrange/person")
	public List<Person> lrange(@RequestParam(value="start", required = false,defaultValue = "0") int start,
			@RequestParam(value="end", required = false,defaultValue = "-1") int end){
		
		return redisTemplate.opsForList().range(PERSON_LIST_KEY_PREFIX,start,end)
				.stream().map(x -> (Person)x)
				.collect(Collectors.toList());
	}
	
	//Hash Operation
	private String getHashKey(long id) {
		return PERSON_HASH_KEY_PREFIX+id;
	}
	
	@PostMapping("/hash/person")
	public void savePersonInHash(@RequestBody List<Person> persons) {
		persons.stream().forEach(person -> {
			Map map = objectMapper.convertValue(person, Map.class);
			
			redisTemplate.opsForHash().putAll(getHashKey(person.getId()), map);
			
		});
	}
	
	@GetMapping("/hash/person/all")
	public List<Person> getPersons(@RequestParam("ids") List<Long> ids){
		
		return ids.stream().map(i-> redisTemplate.opsForHash().entries(getHashKey(i)))
				.map(entryMap -> objectMapper.convertValue(entryMap, Person.class))
				.collect(Collectors.toList());
	}
	
	

}
