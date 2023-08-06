package com.github.regyl.unfriendlyjarvis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.regyl.unfriendlyjarvis.dto.RegistrationDto;
import com.github.regyl.unfriendlyjarvis.support.RegistrationDtoBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests for basic authorization.
 */
public class AuthenticationIntegrationTest extends TestcontainersConfig {

    static final String PASSWORD_SEQUENCE = "AAAAAAAAA";

    static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    static String incrementAndGetPassword() {
        int index = PASSWORD_SEQUENCE.length() - 1;
        char last = PASSWORD_SEQUENCE.charAt(index);
        last += 1;

        return PASSWORD_SEQUENCE.substring(0, index) + last;
    }

    @Test
    void signUpShouldReturnCreated() throws Exception {
        RegistrationDto registrationDto = new RegistrationDto("test-login", "test@gmail.com", "testpassword");
        mockMvc.perform(post("/basic/sign-up")
                        .content(OBJECT_MAPPER.writeValueAsString(registrationDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void signUpWithSameCredentialsShouldThrowException() throws Exception {
        String email = "test1@gmail.com";
        String password = "randompassword";
        signUp(email, password);

        MvcResult mvcResult = signUp(email, password);

        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.FOUND.value());
    }

    @Test
    void signInWithoutSignUpShouldThrowException() throws Exception {
        String email = "test2@gmail.com";
        String password = "randommmmmm3";

        MvcResult mvcResult = signIn(email, password);

        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.FORBIDDEN.value());
    }

    @Test
    void signInAfterSignUpShouldReturnOk() throws Exception {
        String email = "test3@gmail.com";
        String password = "randommmmmm3";
        signUp(email, password);

        MvcResult mvcResult = signIn(email, password);

        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    MvcResult signIn(String username, String password) throws Exception {
        return mockMvc.perform(get("/basic/sign-in")
                        .param("username", username)
                        .param("password", password))
                .andReturn();
    }

    MvcResult signUp(String email) throws Exception {
        return signUp(email, incrementAndGetPassword());
    }

    MvcResult signUp(String email, String password) throws Exception {
        RegistrationDto registrationDto = RegistrationDtoBuilder.builder()
                .email(email)
                .password(password)
                .build();

        return mockMvc.perform(post("/basic/sign-up")
                .content(OBJECT_MAPPER.writeValueAsString(registrationDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }
}
