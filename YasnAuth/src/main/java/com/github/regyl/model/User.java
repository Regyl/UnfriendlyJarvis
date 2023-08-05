package com.github.regyl.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Clock;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_entity")
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity implements UserDetails {

    /**
     * User's login. Must be optional.
     */
    @Column(name = "login", unique = true)
    private String login;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Authority> authorities;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "credentials_expiration_date")
    private LocalDate credentialsExpirationDate;

    @Column(name = "account_non_locked", columnDefinition = "boolean not null default true")
    private boolean accountNonLocked;

    @Column(name = "enabled", columnDefinition = "boolean not null default true")
    private boolean enabled;

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isDateNonExpired(expirationDate);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isDateNonExpired(credentialsExpirationDate);
    }

    private boolean isDateNonExpired(LocalDate date) {
        return date == null ?
                Boolean.TRUE : LocalDate.now(Clock.systemUTC()).isBefore(date);
    }
}
