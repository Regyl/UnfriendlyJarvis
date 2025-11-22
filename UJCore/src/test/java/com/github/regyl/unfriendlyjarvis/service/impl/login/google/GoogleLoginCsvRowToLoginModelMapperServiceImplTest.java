package com.github.regyl.unfriendlyjarvis.service.impl.login.google;

import com.github.regyl.unfriendlyjarvis.annotation.DefaultUnitTest;
import com.github.regyl.unfriendlyjarvis.model.LoginModel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@DefaultUnitTest
class GoogleLoginCsvRowToLoginModelMapperServiceImplTest {

    @InjectMocks
    private GoogleLoginCsvRowToLoginModelMapperServiceImpl service;

    @Test
    void test() {
        String input = "https://www.google.com/abc,email,eanovikov@goida.com,0,1,37,28,0,0";

        LoginModel model = service.apply(input);

        assertThat(model).isNotNull();
        assertThat(model.getOriginUrl()).isEqualTo("www.google.com");
        assertThat(model.getUsernameValue()).isEqualTo("eanovikov@goida.com");
    }
}
