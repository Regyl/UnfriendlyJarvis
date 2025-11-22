package com.github.regyl.unfriendlyjarvis.service.impl.login.google;

import com.github.regyl.unfriendlyjarvis.model.LoginModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;

@Slf4j
@Component
@RequiredArgsConstructor
public class GoogleLoginCsvParserServiceImpl implements Function<MultipartFile, Collection<LoginModel>> {

    private static final String ALLOWED_TYPE = "text/csv";

    private final Function<String, LoginModel> rowMapper;

    @Override
    public Collection<LoginModel> apply(MultipartFile file) {
        log.info("File name {}", file.getOriginalFilename());
        if (!ALLOWED_TYPE.equals(file.getContentType())) {
            throw new IllegalArgumentException(file.getContentType());
        }

        Collection<LoginModel> models;
        try {
            String payload = new String(file.getBytes());
            models = Arrays.stream(payload.split("\r\n"))
                    .skip(1) //skip the header
                    .map(rowMapper)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return models;
    }


}
