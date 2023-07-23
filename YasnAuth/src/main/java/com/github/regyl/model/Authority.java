package com.github.regyl.model;

import com.github.regyl.model.enums.AuthorityEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@Entity
@Table(name = "authority")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Authority extends AbstractEntity implements GrantedAuthority {

    @Column(name = "value")
    @Enumerated(EnumType.STRING)
    private AuthorityEnum value;

    @Override
    public String getAuthority() {
        return value.name();
    }
}
