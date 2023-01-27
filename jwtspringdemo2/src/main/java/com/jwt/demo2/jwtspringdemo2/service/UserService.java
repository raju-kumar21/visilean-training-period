package com.jwt.demo2.jwtspringdemo2.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.demo2.jwtspringdemo2.dao.RoleRepo;
import com.jwt.demo2.jwtspringdemo2.dao.UserRepo;
import com.jwt.demo2.jwtspringdemo2.entity.Role;
import com.jwt.demo2.jwtspringdemo2.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user)
    {
        Role role=roleRepo.findById("User").get();

        Set<Role> roles=new HashSet<>();
        roles.add(role);
        user.setRole(roles);

        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userRepo.save(user);
    }


    public void initRolesAndUser()
    {
        //admin role
        Role adminRole=new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role For Application..");
        roleRepo.save(adminRole);



        //user role
        Role userRole=new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record..");
        roleRepo.save(userRole);



        //Admin Register
        User adminUser=new User();

        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));

        Set<Role> adminRoles=new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepo.save(adminUser);



        // //user register
        // User user=new User();

        // user.setUserFirstName("raju");
        // user.setUserLastName("kumar");
        // user.setUserName("raju123");
        // user.setUserPassword(getEncodedPassword("raju@pass"));

        // Set<Role> userRoles=new HashSet<>();
        // userRoles.add(userRole);
        // user.setRole(userRoles);
        // userRepo.save(user);



    }


    public String getEncodedPassword(String password)
    {
        return passwordEncoder.encode(password);
    }
}
