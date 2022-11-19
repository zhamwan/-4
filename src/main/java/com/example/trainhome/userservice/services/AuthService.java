package com.example.trainhome.userservice.services;

import com.example.trainhome.configuration.RoleConfig;
import com.example.trainhome.userservice.dto.PersonDTO;
import com.example.trainhome.userservice.entities.Person;
import com.example.trainhome.userservice.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public Person addNewPerson(PersonDTO personDTO, String role) {
        Person newPerson = new Person();
        newPerson.setPassword(passwordEncoder.encode(personDTO.getPassword()));
        newPerson.setName(personDTO.getName());
        newPerson.setImage(personDTO.getImage());
        newPerson.setPhoneNumber(personDTO.getPhoneNumber());
        newPerson.setEmail(personDTO.getEmail());
        newPerson.setBirthday(personDTO.getBirthday());
        newPerson.setSex(personDTO.isSex());
        newPerson.setRoleId(roleRepository.findByName(role));
        return newPerson;
    }

    public PersonDTO validatePersonDTO(PersonDTO personDTO) {
        if (personDTO.getPassword() == null || personDTO.getPassword().equals("") || personDTO.getPassword().length() < 5) return null;
        if (personDTO.getName() == null || personDTO.getName().equals("")) return null;
        if (personDTO.getPhoneNumber() == null || personDTO.getPhoneNumber().equals("")
                || !personDTO.getPhoneNumber().matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")) return null;
        if (personDTO.getEmail() == null || personDTO.getEmail().equals("")
                || !personDTO.getEmail().matches("^[_A-Za-z\\d-\\\\+]+(\\\\.[_A-Za-z\\d-]+)*@[A-Za-z\\d-]+(\\\\.[A-Za-z\\d]+)*(\\\\.[A-Za-z]{2,})$")) return null;
        if (personDTO.getBirthday() == null || personDTO.getBirthday().after(Date.valueOf(LocalDate.now()))) return null;
        return personDTO;
    }
}
