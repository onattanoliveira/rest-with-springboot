package com.natan.startup.service;

import com.natan.startup.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;


@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person mockPerson(int i) {
        logger.info("Finding people...");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Nome" + i);
        person.setLastName("Sobrenome" + i);
        person.setAddress("Endereço" + i);
        person.setGender("Masculino");
        return person;
    }

    public Person findById(String id) {
        logger.info("Finfing person...");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Natan");
        person.setLastName("Felipe de Oliveira");
        person.setAddress("Rua Espanha 549, Cascavel, Paraná, Brasil - 85818-270");
        person.setGender("Masculino");
        return person;
    }

    public Person create(Person person) {
        logger.info("Creating person...");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating person...");
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one person...");
    }
}
