package com.regyl.yetanothersocialnetworkcore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
@EqualsAndHashCode(callSuper = true)
@Check(constraints = "login is not null or email is not null")
public class Account extends AbstractEntity {

    @Column(name = "login")
    private String login;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "check_word")
    private String checkWord;
}
