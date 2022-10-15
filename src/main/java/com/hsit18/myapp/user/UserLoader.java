package com.hsit18.myapp.user;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserLoader implements CommandLineRunner {
    @Autowired
    public final UserRepository userRepository;

    public UserLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadUsers();
    }

    public void loadUsers() {
        if (userRepository.count() == 0) {
            userRepository.save(
                    UserData.builder()
                            .name("Harpreet")
                            .email("hst18@gmail.com")
                            .build()
            );
            userRepository.save(
                    UserData.builder()
                            .name("test User")
                            .email("test@gmail.com")
                            .build()
            );
            System.out.println("Sample Users Loaded");
        }
    }
}
