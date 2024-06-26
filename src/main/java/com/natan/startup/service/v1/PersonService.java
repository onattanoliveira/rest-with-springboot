package com.natan.startup.service.v1;

import com.natan.startup.data.vo.v1.PersonVO;
import com.natan.startup.data.vo.v2.PersonVOV2;
import com.natan.startup.exception.ResourceNotFoundException;
import com.natan.startup.mapper.DozerMapper;
import com.natan.startup.mapper.custom.PersonMapper;
import com.natan.startup.model.Person;
import com.natan.startup.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;


@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper mapper;

    public List<PersonVO> findAll() {

        logger.info("Finding all people...");

        return DozerMapper.parseListObject(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {

        logger.info("Finding person...");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person) {

        logger.info("Creating one person!");

        var entity = DozerMapper.parseObject(person, Person.class);
        var vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVOV2 createV2(PersonVOV2 person) {

        logger.info("Creating person V2");

        var entity = mapper.convertVOToEntity(person);
        var vo = mapper.convertEntityToVO(repository.save(entity));
        return vo;
    }

    public PersonVO update(PersonVO person) {

        logger.info("Updating person...");
        
        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id) {

        logger.info("Deleting one person...");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        repository.delete(entity);
    }
}
