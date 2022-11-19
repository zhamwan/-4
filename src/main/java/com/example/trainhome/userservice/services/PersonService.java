package com.example.trainhome.userservice.services;

import com.example.trainhome.userservice.entities.Person;
import com.example.trainhome.userservice.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addPerson(Person person){
        personRepository.save(person);
    }

    public Person findByPersonEmail(String email){
        return personRepository.findByEmail(email);
    }
}
