// This class only aims to manage users. Model-View-Controller (MVC) property. 

package com.Tonysasasa.videomeetingweb.user;

import java.util.ArrayList;

import java.util.List;

import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service

public class UserList {

    // Create a user list. Will be modified into DB
    private static final List<User> userList = new ArrayList<>();

    public User registerUser(User user) {

        if (userList.size() != 0) {
            for (User userAccount : userList) {
                if (userAccount.getEmail().equals(user.getEmail())) {
                    throw new RuntimeException("Email has been registered.");
                }
            }
        }
        user.setStatus("online");
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        user.setUsername(user.getUsername());
        userList.add(user);

        return user;
    }

    public User login(User user) {

        // Use Intstream to find the login user by unique eamil address
        int currID = IntStream.range(0, userList.size())
                .filter(i -> userList.get(i).getEmail().equals(user.getEmail()))
                .findAny()
                .orElseThrow(() -> new RuntimeException("User not found."));

        User currUser = userList.get(currID);
        if (!currUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Password incorrect.");
        }
        currUser.setStatus("online");
        return currUser;
    }

    public void logout(User user) {
        int currID = IntStream.range(0, userList.size())
                .filter(i -> userList.get(i).getEmail().equals(user.getEmail()))
                .findAny()
                .orElseThrow(() -> new RuntimeException("User not found."));

        userList.get(currID).setStatus("offline");
    }

    public List<User> findAll() {
        return userList;
    }
}
