package com.validation.springmvcvalidation.entities;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginData {

    //How to put validations using validation api
    @NotBlank(message = "Username cannot be empty!")
    @Size(min=3, max=12, message = "username must be between 3-12 characters")
    private String userName;
    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Invalid email")
    private String email;

    @AssertTrue(message = "Must agree terms and conditions")
    private boolean agreed;

    public LoginData() {
    }

    public LoginData(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LoginData userName(String userName) {
        setUserName(userName);
        return this;
    }

    public LoginData email(String email) {
        setEmail(email);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " userName='" + getUserName() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }
   


    /**
     * @return boolean return the agreed
     */
    public boolean isAgreed() {
        return agreed;
    }

    /**
     * @param agreed the agreed to set
     */
    public void setAgreed(boolean agreed) {
        this.agreed = agreed;
    }

}