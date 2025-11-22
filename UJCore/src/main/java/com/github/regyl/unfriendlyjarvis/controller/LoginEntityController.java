package com.github.regyl.unfriendlyjarvis.controller;

import com.github.regyl.unfriendlyjarvis.entity.LoginEntity;
import com.github.regyl.unfriendlyjarvis.service.login.LoginService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@RestController
@RequestMapping("/logins")
@RequiredArgsConstructor
public class LoginEntityController {

    private final LoginService service;

    @PostMapping
    public void save(@NotNull @RequestParam("file") MultipartFile file) {
        service.save(file);
    }

    @GetMapping
    public Collection<LoginEntity> findAll() {
        return service.findAll();
    }
}
