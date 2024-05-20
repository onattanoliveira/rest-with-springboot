package com.natan.startup.service;

import com.natan.startup.exception.ResourceNotFoundException;
import com.natan.startup.model.Person;
import com.natan.startup.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;


@Service
public class PersonService {
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Finding all people...");
        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finfing person...");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
    }

    public Person create(Person person) {
        logger.info("Creating person...");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating person...");
        Person entity = repository.findById(person.getId()).orElseThrow();
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(person);
    }

    public void delete(Long id) {
        logger.info("Deleting one person...");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        repository.delete(entity);
    }
}
