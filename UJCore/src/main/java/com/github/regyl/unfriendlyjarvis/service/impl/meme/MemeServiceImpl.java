package com.github.regyl.unfriendlyjarvis.service.impl.meme;

import com.github.regyl.unfriendlyjarvis.entity.Account;
import com.github.regyl.unfriendlyjarvis.entity.MemeEntity;
import com.github.regyl.unfriendlyjarvis.entity.enums.Source;
import com.github.regyl.unfriendlyjarvis.repository.MemeRepository;
import com.github.regyl.unfriendlyjarvis.service.SecurityContextService;
import com.github.regyl.unfriendlyjarvis.service.meme.MemeService;
import com.github.regyl.unfriendlyjarvis.service.s3.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.UUID;

/**
 * Implementation of MemeService.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MemeServiceImpl implements MemeService {

    private final MemeRepository repository;
    private final S3Service s3Service;
    private final SecurityContextService securityContextService;

    @Override
    @Transactional
    public MemeEntity uploadMeme(MultipartFile file, String source) {
        Account account = securityContextService.getAuthorizedAccount();

        // Generate unique object name
        String objectName = generateObjectName(file.getOriginalFilename());

        // Upload file to MinIO
        String bucketPath = s3Service.uploadFile(
                "meme",
                objectName,
                file
        );

        // Create meme entity
        MemeEntity memeEntity = MemeEntity.builder()
                .account(account)
                .bucketPath(bucketPath)
                .source(parseSource(source))
                .build();

        return repository.save(memeEntity);
    }

    @Override
    public Collection<MemeEntity> findAll() {
        Account account = securityContextService.getAuthorizedAccount();
        return repository.findAllByAccount(account);
    }

    /**
     * Generate unique object name for file in bucket.
     *
     * @param originalFilename original filename
     * @return unique object name
     */
    private String generateObjectName(String originalFilename) {
        String extension = "";
        if (originalFilename != null && originalFilename.contains(".")) {
            extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        return UUID.randomUUID() + extension;
    }

    /**
     * Parse source string to Source enum.
     * Returns OTHER if source is null or invalid.
     *
     * @param source source string
     * @return Source enum
     */
    private Source parseSource(String source) {
        if (source == null || source.isBlank()) {
            return Source.OTHER;
        }
        try {
            return Source.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            log.warn("Invalid source value: {}, using OTHER", source);
            return Source.OTHER;
        }
    }
}

