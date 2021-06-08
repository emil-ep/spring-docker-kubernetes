package com.innoventes.jukebox.models.entity;

import com.innoventes.jukebox.constants.UserType;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "JUKEBOX_ADMIN")
public class JukeboxAdmin extends AbstractUser{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public JukeboxAdmin() {
    }

    public JukeboxAdmin(String email, String password, String firstName, String lastName){
        super(email, password, UserType.JUKEBOX_ADMIN);
        this.firstName = firstName;
        this.lastName = lastName;
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
}
