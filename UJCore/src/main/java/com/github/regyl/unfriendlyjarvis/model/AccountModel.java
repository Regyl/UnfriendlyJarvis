package com.github.regyl.unfriendlyjarvis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {

    private Long id;
    private String login;
    private String email;
    private Long yandexMusicUserId;
}
