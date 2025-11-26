package com.github.regyl.unfriendlyjarvis.controller.dto.oauth.github;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEmailDto {

    private String email;

    private Boolean primary;

    private Boolean verified;

    private String visibility;
}
