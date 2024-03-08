package iuh.fit.se.baotruc_20072261_ktpm.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import iuh.fit.se.baotruc_20072261_ktpm.backend.models.User;
import iuh.fit.se.baotruc_20072261_ktpm.backend.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByEmailAndPasswordHash(String email, String passwordHash){
        return userRepository.findUserByEmailAndPasswordHash(email,passwordHash);
    }
    public Optional<User> findById(long id){
        return userRepository.findById(id);
    }


}
