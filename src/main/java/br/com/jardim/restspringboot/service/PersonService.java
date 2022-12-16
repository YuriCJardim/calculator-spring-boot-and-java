package br.com.jardim.restspringboot.service;

import br.com.jardim.restspringboot.data.vo.v1.PersonVO;
import br.com.jardim.restspringboot.data.vo.v2.PersonVOV2;
import br.com.jardim.restspringboot.exceptions.ResourceNotFoundException;
import br.com.jardim.restspringboot.mapper.DozerMapper;
import br.com.jardim.restspringboot.mapper.custom.PersonMapper;
import br.com.jardim.restspringboot.model.Person;
import br.com.jardim.restspringboot.repositories.PersonRepository;
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
    PersonMapper personMapper;


    public PersonVO findById(Long id) {

        logger.info("Finding one person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAll() {
        logger.info("Finding All people!");
        return DozerMapper.parseListObject(repository.findAll(), PersonVO.class);
    }

    public PersonVO create(PersonVO personVO) {
        logger.info("Creating one person!");
        var entity = DozerMapper.parseObject(personVO, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVOV2 createV2(PersonVOV2 personVOV2) {
        logger.info("Creating one person!");
        var entity = personMapper.convertVoToEntity(personVOV2);
        var vo = personMapper.convertEntityToVo(repository.save(entity));
        return vo;
    }

    public PersonVO update(PersonVO personVO) {

        logger.info("Updating one person!");

        var entity = repository.findById(personVO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(personVO.getFirstName());
        entity.setLastName(personVO.getLastName());
        entity.setAddress(personVO.getAddress());
        entity.setGender(personVO.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(long id) {

        logger.info("Deleting one personVO!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);
    }
}
