package com.github.regyl.model;

import com.github.regyl.dto.PasswordContainer;
import jakarta.persistence.*;
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
public class User extends AbstractEntity implements UserDetails, PasswordContainer {

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Authority> authorities;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "credentials_expiration_date")
    private LocalDate credentialsExpirationDate;

    @Column(name = "account_non_locked", columnDefinition = "NOT NULL DEFAULT TRUE")
    private boolean accountNonLocked;

    @Column(name = "enabled", columnDefinition = "NOT NULL DEFAULT TRUE")
    private boolean enabled;

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
