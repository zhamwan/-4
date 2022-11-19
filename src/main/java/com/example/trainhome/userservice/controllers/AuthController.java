package com.example.trainhome.userservice.controllers;

import com.example.trainhome.configuration.RoleConfig;
import com.example.trainhome.userservice.dto.CoachDTO;
import com.example.trainhome.userservice.dto.PersonDTO;
import com.example.trainhome.userservice.entities.Person;
import com.example.trainhome.userservice.entities.Session;
import com.example.trainhome.userservice.services.AuthService;
import com.example.trainhome.userservice.tokens.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.Date;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private HttpServletRequest context;

    @CrossOrigin
    @PostMapping(value = "client", produces = "application/json")
    public ResponseEntity<?> registerClient(@RequestBody PersonDTO personDTO) {
        PersonDTO checkedPersonDTO = authService.validatePersonDTO(personDTO);
        if (checkedPersonDTO == null) {
            return new ResponseEntity<>("Невалидные данные", HttpStatus.BAD_REQUEST);
        }
        Person newPerson = authService.addNewPerson(personDTO, RoleConfig.ROLE_CLIENT.toString());
        Session session = new Session();
        session.setExpired(false);
        session.setCreatedAt(Date.from(Instant.now()));
        String token = TokenUtils.generate(newPerson);
        session.setToken(token);
        session.setPerson(newPerson);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "coach", produces = "application/json")
    public ResponseEntity<?> registerCoach(@RequestBody CoachDTO coachDTO) {
        return null;
    }

    @CrossOrigin
    @PostMapping(value = "login", produces = "application/json")
    public ResponseEntity<?> login() {
        return null;
    }

    @CrossOrigin
    @PostMapping(value = "logout", produces = "application/json")
    public ResponseEntity<?> logout() {
        return null;
    }
}
