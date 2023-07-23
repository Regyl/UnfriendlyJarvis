package com.github.regyl.controller;

import com.github.regyl.api.AuthService;
import com.github.regyl.dto.RegistrationDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Username & password-based authentication.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/password-based")
public class AuthController {

    private final AuthService authService;

    /**
     * Authorize by username/password.
     *
     * @param login     username
     * @param password  password
     * @return          flag is credentials valid.
     */
    @GetMapping("/sign-in")
    public boolean signIn(@RequestParam("login") @NotEmpty String login, @RequestParam("password") @NotEmpty String password) {
        return authService.signIn(login, password);
    }

    /**
     * Create new user.
     *
     * @param registrationDto DTO with information about new user
     */
    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody @NotNull @Valid RegistrationDto registrationDto) {
        authService.saveNewUser(registrationDto);
    }
}
