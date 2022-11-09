package br.com.caps.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caps.exceptions.ResourceNotFoundException;
import br.com.caps.model.Person;
import br.com.caps.repository.PersonRepository;

@Service
public class PersonService {

	
	@Autowired
	PersonRepository repository;
	
	private Logger logger = Logger.getLogger(PersonService.class.getName());

	public List<Person> findAll() {
		logger.info("Finding all people");
		return repository.findAll();
	}

	public Person findById(Long id) {
		logger.info("Finding one person");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found for this Id"));
	}
	
	public Person create(Person person) {
		logger.info("Create one person");
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("Update one person");
		Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Not update"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person");
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not delete"));
		repository.delete(entity);
	}


}
