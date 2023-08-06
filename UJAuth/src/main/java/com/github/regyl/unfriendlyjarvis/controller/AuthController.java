package com.github.regyl.unfriendlyjarvis.controller;

import com.github.regyl.unfriendlyjarvis.api.AuthService;
import com.github.regyl.unfriendlyjarvis.dto.RegistrationDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Basic username & password authorization.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/basic")
public class AuthController {

    private final AuthService authService;

    /**
     * Authorize by username/password.
     *
     * @param username  username
     * @param password  password
     * @return          flag are credentials valid
     */
    @GetMapping("/sign-in")
    public boolean signIn(@RequestParam("username") @NotEmpty String username,
                          @RequestParam("password") @NotEmpty String password) {
        return authService.signIn(username, password);
    }

    /**
     * Creates new user.
     *
     * @param registrationDto DTO with information about new user
     */
    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody @NotNull @Valid RegistrationDto registrationDto) {
        authService.signUp(registrationDto);
    }
}
