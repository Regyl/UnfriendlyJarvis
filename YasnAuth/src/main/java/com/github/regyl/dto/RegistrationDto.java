package com.github.regyl.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO used to transfer information about user that should be created.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {

    private String login;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z\\d]{8,}$")
    private String password;
}
