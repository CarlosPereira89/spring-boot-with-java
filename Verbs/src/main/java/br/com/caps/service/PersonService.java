package br.com.caps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.caps.model.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());

	public List<Person> findAll() {
		logger.info("Finding all people");
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	public Person findById(String id) {

		logger.info("Finding one person");

		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Carlos");
		person.setLastName("Pereira da Silva");
		person.setAdress("Mauá - São Paulo - Brasil");
		person.setGender("Masculino");
		return person;
	}
	
	public Person create(Person person) {
		logger.info("Create one person");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Update one person");
		return person;
	}
	
	public void delete(String id) {
		logger.info("Deleting one person");
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("First name: " + i);
		person.setLastName("Last name: " + i);
		person.setAdress("Some adress in Brasil: " + i);
		person.setGender("Masculino");
		return person;
	}

}
