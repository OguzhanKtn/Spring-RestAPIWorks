package com.works.restjpa.services;

import com.works.restjpa.configs.Rest;
import com.works.restjpa.entities.Users;
import com.works.restjpa.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    final TinkEncDec tinkEncDec;
    final UserRepository userRepository;

    public ResponseEntity save(Users user){
        try {
            String chipherText = tinkEncDec.encrypt(user.getPassword());
            user.setPassword(chipherText);
            userRepository.save(user);
            Rest rest = new Rest(true,user);
            return new ResponseEntity(rest, HttpStatus.OK);
        }catch (Exception ex){
            Rest rest = new Rest(false,user);
            return new ResponseEntity(rest, HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity login(Users user) {

        for (Users users : userRepository.findAll()) {
            String plainText = tinkEncDec.decrypt(users.getPassword());
            if (user.getPassword().equals(plainText) && user.getEmail().equals(users.getEmail())) {
                Rest rest = new Rest(true, user);
                return new ResponseEntity(rest, HttpStatus.OK);
            } else {
                Rest rest = new Rest(false, user);
                return new ResponseEntity(rest, HttpStatus.BAD_REQUEST);
            }
        }

        return null;
    }
}

