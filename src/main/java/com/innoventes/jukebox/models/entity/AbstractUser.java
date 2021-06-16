package com.innoventes.jukebox.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.innoventes.jukebox.constants.UserType;

import javax.persistence.*;

@Entity(name = "tbl_users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public class AbstractUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "user_type", insertable = false, updatable = false)
    private String userType;

    @OneToOne
    @JoinColumn(name = "profile_pic_id")
    private FileStore profilePic;

    public AbstractUser() {
    }

    public AbstractUser(String email, String password, UserType userType) {
        this.email = email;
        this.password = password;
        this.userType = userType.name();
    }

    public FileStore getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(FileStore profilePic) {
        this.profilePic = profilePic;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
