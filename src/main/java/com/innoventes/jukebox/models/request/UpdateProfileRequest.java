package com.innoventes.jukebox.models.request;

import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateProfileRequest {

    @NotNull
    private Integer id;

    @NotBlank(message = "first name cannot be empty")
    @Size(min = 3, max = 15)
    private String firstName;

    private String lastName;

    //No need to update email now since we have only an admin user. When other users are introduced,
    //this field can be uncommented and used for updating the email address of user
//    private String email;
    @NotBlank(message = "user type cannot be empty")
    private String userType;

    private String currentPassword;

    private String password;

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
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

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
