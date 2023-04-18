
package com.jwtdemo3neo4j.jwtdemo3neo4j.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwtdemo3neo4j.jwtdemo3neo4j.entity.User;
import com.jwtdemo3neo4j.jwtdemo3neo4j.repo.UserRepo;

@Service
public class UserService {

    private UserRepo userRepo;

    private PasswordEncoder passwordEncoder;


    public UserService(UserRepo userRepo,PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerNewUser(User user) {
        user.setRole("SubAdmin");

        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userRepo.save(user);
    }

    public void initRolesAndUser() {

        // Super-Admin user create
        User adminUser = new User("admin123", passwordEncoder.encode("admin@pass"), "SuperAdmin");
        userRepo.save(adminUser);

        // Sub-Admin user create
        User subAdminUser = new User("subadmin123", passwordEncoder.encode("subadmin@pass"), "SubAdmin");
        userRepo.save(subAdminUser);
        System.out.println("User is Created.....");

    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

}
