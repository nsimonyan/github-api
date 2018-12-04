package com.nsimonyan.wf.github.model;

import java.time.LocalDate;

public class User {
    private final String name;
    private final String email;
    private final LocalDate date;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDate() {
        return date;
    }
    public User(final String name, final String email, final LocalDate date){
        this.name = name;
        this.email = email;
        this.date = date;
    }
}
