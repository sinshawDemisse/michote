package com.michote.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by jtq603 on 10/15/16.
 */

@Entity
@Table(name = "users")
public class SampleUser {

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An autogenerated id (unique for each user in the db)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // The user's email
    @NotNull
    private String email;

    // The user's name
    @NotNull
    private String name;

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    public SampleUser() { }

    public SampleUser(long id) {
        this.id = id;
    }

    public SampleUser(String email, String name) {
        this.email = email;
        this.name = name;
    }

    // Getter and setter methods

    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String value) {
        this.email = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

} // class SampleUser
