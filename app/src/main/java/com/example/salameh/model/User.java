package com.example.salameh.model;

public class User {
    private String UserName;
    private String password;
    private String email;
    private String phoneNumber;

    public User(String userName, String password, String email,String phoneNumber) {
       this.UserName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber=phoneNumber;
    }
public User()
{

}
    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
