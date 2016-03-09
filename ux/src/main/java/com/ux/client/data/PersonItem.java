package com.ux.client.data;


import java.io.Serializable;

public class PersonItem implements Serializable {


    private static final long serialVersionUID = 6684117360546200395L;

    private String username;

    private String email;

    // Needed for Serializable implementation
    @SuppressWarnings({"UnusedDeclaration", "SuppressionAnnotation"})
    public PersonItem() {

    }

    public PersonItem(final String username, final String email) {

        this.username = username;
        this.email = email;
    }


    public String getUsername() {

        return username;
    }

    public void setUsername(final String username) {

        this.username = username;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(final String email) {

        this.email = email;
    }
}
