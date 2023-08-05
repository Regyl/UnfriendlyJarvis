package com.github.regyl.unfriendlyjarvis.support;

import com.github.regyl.unfriendlyjarvis.dto.RegistrationDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public final class RegistrationDtoBuilder {
    private @NotEmpty String username;
    private @Email @NotEmpty String email;
    private @NotEmpty @Pattern(regexp = "^[a-zA-Z\\d]{8,}$") String password;

    private RegistrationDtoBuilder() {
    }

    public static RegistrationDtoBuilder builder() {
        return new RegistrationDtoBuilder();
    }

    public RegistrationDtoBuilder username(String username) {
        this.username = username;
        return this;
    }

    public RegistrationDtoBuilder email(String email) {
        this.email = email;
        return this;
    }

    public RegistrationDtoBuilder password(String password) {
        this.password = password;
        return this;
    }

    public RegistrationDto build() {
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setLogin(username);
        registrationDto.setEmail(email);
        registrationDto.setPassword(password);
        return registrationDto;
    }
}
