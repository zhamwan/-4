package com.example.trainhome.userservice.services;

import com.example.trainhome.userservice.dto.RegisterRequestDTO;
import com.example.trainhome.userservice.dto.SportPriceDTO;
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

    public Person addNewPerson(RegisterRequestDTO requestDTO, String role) {
        Person newPerson = new Person();
        newPerson.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        newPerson.setName(requestDTO.getName());
        newPerson.setImage(requestDTO.getImage());
        newPerson.setPhoneNumber(requestDTO.getPhoneNumber());
        newPerson.setEmail(requestDTO.getEmail());
        newPerson.setBirthday(requestDTO.getBirthday());
        newPerson.setSex(requestDTO.isSex());
        newPerson.setRoleId(roleRepository.findByName(role));
        return newPerson;
    }

    public void fillCoach(RegisterRequestDTO requestDTO) {

    }

    public Person findByEmail(String email) {
        return null;
    }

    public RegisterRequestDTO validateRegisterRequestDTO(RegisterRequestDTO requestDTO) {
        if (requestDTO.getPassword() == null || requestDTO.getPassword().equals("") || requestDTO.getPassword().length() < 5) return null;
        if (requestDTO.getName() == null || requestDTO.getName().equals("")) return null;
        if (requestDTO.getPhoneNumber() == null || requestDTO.getPhoneNumber().equals("")
                || !requestDTO.getPhoneNumber().matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")) return null;
        if (requestDTO.getEmail() == null || requestDTO.getEmail().equals("")
                || !requestDTO.getEmail().matches("^[_A-Za-z\\d-\\\\+]+(\\\\.[_A-Za-z\\d-]+)*@[A-Za-z\\d-]+(\\\\.[A-Za-z\\d]+)*(\\\\.[A-Za-z]{2,})$")) return null;
        if (requestDTO.getBirthday() == null || requestDTO.getBirthday().after(Date.valueOf(LocalDate.now()))) return null;
        for (SportPriceDTO dto: requestDTO.getListPrices()) {
            if (dto.getPrice() <= 0) return null;
        }
        return requestDTO;
    }
}
