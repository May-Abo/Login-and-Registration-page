package com.test.beans;

public class UserWeb {
    
    private String id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String status;
    private String country;
    private String phoneNumber;

    public UserWeb() {
    }

    public UserWeb(String id, String userName, String firstName, String lastName, String email, String password, String status, String country, String phoneNumber) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.status = status;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public UserWeb(String userName, String firstName, String lastName, String email, String password, String country, String phoneNumber) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }
    
    

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserWeb{" + "id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", status=" + status + ", country=" + country + ", phoneNumber=" + phoneNumber + '}';
    }
    
    

    
    
    
    

}
