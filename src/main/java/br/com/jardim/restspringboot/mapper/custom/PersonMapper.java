package br.com.jardim.restspringboot.mapper.custom;


import br.com.jardim.restspringboot.data.vo.v2.PersonVOV2;
import br.com.jardim.restspringboot.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVo(Person person){

        PersonVOV2 vov2 = new PersonVOV2();
        vov2.setId(person.getId());
        vov2.setFirstName(person.getFirstName());
        vov2.setLastName(person.getLastName());
        vov2.setAddress(person.getAddress());
        vov2.setGender(person.getGender());
        vov2.setBirthDay(new Date());
        return vov2;
    }

    public Person convertVoToEntity(PersonVOV2 person){
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
       // entity.setBirthDay(new Date());
        return entity;
    }



}
