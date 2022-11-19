package com.example.trainhome.userservice.controllers;

import com.example.trainhome.configuration.RoleConfig;
import com.example.trainhome.userservice.dto.AuthRequestDTO;
import com.example.trainhome.userservice.dto.RegisterRequestDTO;
import com.example.trainhome.userservice.entities.Person;
import com.example.trainhome.userservice.entities.Session;
import com.example.trainhome.userservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HttpServletRequest context;

    @CrossOrigin
    @PostMapping(value = "register", produces = "application/json")
    public ResponseEntity<?> registration(@RequestBody RegisterRequestDTO requestDTO, @RequestParam(name = "role") String role) {
        RegisterRequestDTO checkedRequestDTO = authService.validateRegisterRequestDTO(requestDTO);
        if (checkedRequestDTO == null) {
            return ResponseEntity.badRequest().body("Невалидные данные");
        }
        Person newPerson = authService.addNewPerson(requestDTO, RoleConfig.valueOf(role.toUpperCase()).toString());
        String token = authService.createSession(newPerson);
        if (role.toUpperCase().equals(RoleConfig.ROLE_COACH.toString())) {
            authService.fillCoach(requestDTO, newPerson.getId());
        }
        return ResponseEntity.ok().body(token);
    }

    @CrossOrigin
    @PostMapping(value = "login", produces = "application/json")
    public ResponseEntity<?> login(@RequestBody AuthRequestDTO authRequestDTO) {
        try {
            Person personFromDB = authService.findByEmail(authRequestDTO.getEmail());
            if (personFromDB == null) throw new IllegalArgumentException();
            else if (!passwordEncoder.matches(authRequestDTO.getPassword(), personFromDB.getPassword())) throw new IllegalArgumentException();
            else {
                String token = authService.createSession(personFromDB);
                return ResponseEntity.ok().body(token);
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Неправильный email или пароль");
        }
    }

    @CrossOrigin
    @PostMapping(value = "logout", produces = "application/json")
    public ResponseEntity<?> logout() {
        Session session = (Session) (context.getAttribute("session"));
        authService.closeSession(session);
        return ResponseEntity.ok().body("");
    }
}
