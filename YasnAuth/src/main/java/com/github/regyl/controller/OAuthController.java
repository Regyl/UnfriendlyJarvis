package com.github.regyl.controller;

import com.github.regyl.api.oauth.OAuthService;
import com.github.regyl.dto.oauth.OAuthInitializationDto;
import com.github.regyl.exceptiion.JarvisException;
import com.github.regyl.model.enums.OAuthProviderType;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/oauth")
public class OAuthController {

    private final Map<OAuthProviderType, OAuthService> oAuthServiceMap;

    public OAuthController(List<OAuthService> oAuthServices) {
        this.oAuthServiceMap = oAuthServices.stream()
                .collect(Collectors.toMap(OAuthService::getSupportedProvider, Function.identity()));
    }

    @GetMapping("/sign-in")
    public boolean signIn(@RequestParam("code") String code, @RequestParam("state") String state,
                          @RequestParam("oAuthProviderType") OAuthProviderType oAuthProviderType) {
        OAuthService oAuthService = getOAuthService(oAuthProviderType);

        return oAuthService.exists(new OAuthInitializationDto(code, state, oAuthProviderType));
    }

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody @NotNull OAuthInitializationDto registrationDto) {
        OAuthService oAuthService = getOAuthService(registrationDto.getOAuthProviderType());

        oAuthService.signUp(registrationDto);
    }

    private OAuthService getOAuthService(OAuthProviderType providerType) {
        OAuthService oAuthService = oAuthServiceMap.get(providerType);
        if (oAuthService == null) {
            throw new JarvisException("Unsupported provider type " + providerType.name());
        }

        return oAuthService;
    }
}
