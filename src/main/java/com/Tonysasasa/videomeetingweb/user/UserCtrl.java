// This class aims to achieve the controller property in Model-View-Controller (MVC). Received requests from client, 
// send the request to controller phase (here), then call the corresponding model methods (User)

package com.Tonysasasa.videomeetingweb.user;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// This is the class to manipulate the user list.

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController // combines @Controller and @ResponseBody. Implement this class to a controller
@RequestMapping("/api/v1/users") // mapping an HTTP request to controller. Set value to the specific address
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j

public class UserCtrl {
    private final UserList MyService;

    public int regCounter = 0; //

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return MyService.registerUser(user);
    }

    // login the user by the correct email address and password. Automaticallt set
    // the status to online
    // Maps the HttpRequest body to a transfer or domain object,
    // enabling automatic deserialization of the inbound HttpRequest body onto a
    // Java object. In this case is user
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return MyService.login(user);
    }

    // logout the current user as shown the status to offline
    @PostMapping("/logout")
    public void logout(@RequestBody User user) {
        MyService.logout(user);
    }

    @GetMapping
    public List<User> findAll() {
        return MyService.findAll();
    }

    // Add Exception handler to handle exception. Get the exception message
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());

    }
}
