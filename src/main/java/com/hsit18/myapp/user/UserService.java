package com.hsit18.myapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserData> getUsers() {
        List<UserData> userData = new ArrayList();
        userRepository.findAll().forEach(userData::add);
        return userData;
    }
}
