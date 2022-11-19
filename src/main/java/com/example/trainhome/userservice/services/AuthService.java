package com.example.trainhome.userservice.services;

import com.example.trainhome.userservice.dto.PersonDTO;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class AuthService {


    public void addNewPerson(PersonDTO personDTO) {

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
