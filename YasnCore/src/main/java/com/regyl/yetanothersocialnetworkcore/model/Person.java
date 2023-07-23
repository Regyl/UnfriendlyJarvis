package com.regyl.yetanothersocialnetworkcore.model;

import com.regyl.yetanothersocialnetworkcore.model.enums.Gender;
import com.regyl.yetanothersocialnetworkcore.model.enums.Marital;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
@EqualsAndHashCode(callSuper = true)
@Check(constraints = "gender = 'MALE' or gender = 'FEMALE' or gender is null")
public class Person extends AbstractEntity {

    @Column(name = "phone")
    private int phone;

    @Column(name = "first_name")
    private String firsName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "live_place")
    private String livePlace;

    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status")
    private Marital maritalStatus;

    @Column(name = "work_place")
    private String workPlace;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "is_russian")
    private Boolean isRussian;

}
