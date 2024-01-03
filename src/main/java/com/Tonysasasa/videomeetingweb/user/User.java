// Defining User properties by GetSet methods

package com.Tonysasasa.videomeetingweb.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class User {
    private String username;
    private String email; // Unique email for each registered user
    private String password;
    private String status; // online or offline or Busy

    User(String username, String email, String password, String status) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
