package com.ux.server.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="PERSON")
public class Person implements Serializable {

    private static final long serialVersionUID = -4056223491568569458L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", nullable = false)
    private int id;

    @Column(name="NAME", nullable = false)
    private String username;

    @Column(name="EMAIL", nullable = false)
    private String email;

    public Person() {

    }

    public Person(final String username, final String email) {

        this.username = username;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setEmail(String name) {
        this.email = email;
    }

}
