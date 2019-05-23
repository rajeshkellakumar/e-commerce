package com.omnicuris.ecommerce.ecommerce.service;

import com.omnicuris.ecommerce.ecommerce.entity.User;
import com.omnicuris.ecommerce.ecommerce.exception.UserException;
import com.omnicuris.ecommerce.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserException("No existing user with id: "+id.toString()));
    }

    public void deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserException("No existing user with id: "+id.toString()));
        userRepository.delete(user);
    }

    public User findUserByEmailId(String emailId) {
        User user = userRepository.findByEmailId(emailId);
        if(user==null){
            throw new UserException("No existing user with emailId: "+emailId);
        }
        return user;
    }
}
