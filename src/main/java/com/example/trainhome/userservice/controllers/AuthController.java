package com.example.trainhome.userservice.controllers;

import com.example.trainhome.userservice.dto.CoachDTO;
import com.example.trainhome.userservice.dto.PersonDTO;
import com.example.trainhome.userservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @CrossOrigin
    @PostMapping(value = "client", produces = "application/json")
    public ResponseEntity<?> registerClient(@RequestBody PersonDTO personDTO) {
        PersonDTO checkedPersonDTO = authService.validatePersonDTO(personDTO);
        if (checkedPersonDTO == null) {
            return new ResponseEntity<>("Невалидные данные", HttpStatus.BAD_REQUEST);
        }
        authService.addNewPerson(personDTO);
        return new ResponseEntity<>("Регистрация прошла успешно", HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "coach", produces = "application/json")
    public ResponseEntity<?> registerCoach(@RequestBody CoachDTO coachDTO) {
        return null;
    }
}
