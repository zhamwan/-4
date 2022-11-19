package com.example.trainhome.userservice.controllers;


import com.example.trainhome.userservice.entities.Person;
import com.example.trainhome.userservice.repositories.RoleRepository;
import com.example.trainhome.userservice.services.PersonService;
import com.example.trainhome.userservice.tokens.TokenUtils;
import com.example.trainhome.userservice.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.trainhome.userservice.dto.PersonDTO;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
    private final PersonService personService;
    private final PersonRepository personRepository;
    
    @Autowired
    public PersonController(PersonService personService, PersonRepository personRepository) {
        this.personService = personService;
        this.personRepository = personRepository;
    }

    @CrossOrigin
    @GetMapping
    ResponseEntity<?> getPersonByEmail(@RequestBody String email) {
        Person person = personService.findByPersonEmail(email);
        person.setPassword(null);
        ResponseEntity e = ResponseEntity.ok(person);
        return e;
    }

    @CrossOrigin
    @PostMapping("/update")
    ResponseEntity<?> updatePerson(@RequestBody PersonDTO personDTO) {
        Person person = personService.findByPersonEmail(personDTO.getEmail());
        person.setBirthday(personDTO.getBirthday());
        person.setName(personDTO.getName());
        person.setImage(personDTO.getImage());
        person.setPhoneNumber(personDTO.getPhoneNumber());
        return ResponseEntity.ok(person);
    }

    @CrossOrigin
    @DeleteMapping
    ResponseEntity<?> deletePerson(@RequestBody String email) {
        Person person = personService.findByPersonEmail(email);
        return ResponseEntity.ok(personRepository.deletePerson(person));
    }
}
