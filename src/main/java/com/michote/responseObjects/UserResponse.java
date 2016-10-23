package com.michote.responseObjects;

/**
 * Created by jtq603 on 10/23/16.
 */
public class UserResponse {

    private long userId;

    private String email;

    private String password;

    // The user's firstName
    private String firstName;

    // The user's lastName
    private String lastName;

    // The user's phoneNo
    private String phoneNo;

    private String contactPreferance;

    private String seconderyPhone;

    public UserResponse() {

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getContactPreferance() {
        return contactPreferance;
    }

    public void setContactPreferance(String contactPreferance) {
        this.contactPreferance = contactPreferance;
    }

    public String getSeconderyPhone() {
        return seconderyPhone;
    }

    public void setSeconderyPhone(String seconderyPhone) {
        this.seconderyPhone = seconderyPhone;
    }
}
