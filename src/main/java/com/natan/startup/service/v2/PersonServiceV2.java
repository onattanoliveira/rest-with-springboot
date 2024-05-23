package com.natan.startup.service.v2;

import com.natan.startup.data.vo.v2.PersonVOV2;
import com.natan.startup.exception.ResourceNotFoundException;
import com.natan.startup.mapper.DozerMapper;
import com.natan.startup.mapper.custom.PersonMapper;
import com.natan.startup.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;


@Service
public class PersonServiceV2 {

    private Logger logger = Logger.getLogger(PersonServiceV2.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper mapper;

    public List<PersonVOV2> findAll() {

        logger.info("Finding all people...");

        return DozerMapper.parseListObject(repository.findAll(), PersonVOV2.class);
    }

    public PersonVOV2 findById(Long id) {

        logger.info("Finding person...");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        return DozerMapper.parseObject(entity, PersonVOV2.class);
    }

    public PersonVOV2 createV2(PersonVOV2 person) {

        logger.info("Creating person V2");

        var entity = mapper.convertVOToEntity(person);
        var vo = mapper.convertEntityToVO(repository.save(entity));
        return vo;
    }

    public PersonVOV2 update(PersonVOV2 person) {

        logger.info("Updating person...");
        
        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = mapper.convertEntityToVO(repository.save(entity));
        return vo;
    }

    public void delete(Long id) {

        logger.info("Deleting one person...");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        repository.delete(entity);
    }
}
