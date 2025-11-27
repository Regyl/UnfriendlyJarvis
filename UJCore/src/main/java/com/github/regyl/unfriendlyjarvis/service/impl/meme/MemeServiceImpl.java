package com.github.regyl.unfriendlyjarvis.service.impl.meme;

import com.github.regyl.unfriendlyjarvis.controller.dto.meme.MemeDto;
import com.github.regyl.unfriendlyjarvis.entity.Account;
import com.github.regyl.unfriendlyjarvis.entity.MemeEntity;
import com.github.regyl.unfriendlyjarvis.model.MemeModel;
import com.github.regyl.unfriendlyjarvis.repository.MemeRepository;
import com.github.regyl.unfriendlyjarvis.service.SecurityContextService;
import com.github.regyl.unfriendlyjarvis.service.meme.MemeService;
import com.github.regyl.unfriendlyjarvis.service.s3.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.UUID;
import java.util.function.Function;

/**
 * Implementation of MemeService.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MemeServiceImpl implements MemeService {

    private final MemeRepository repository;
    private final S3Service s3Service;
    private final SecurityContextService securityContextService;
    private final Function<MemeModel, MemeEntity> memeMapper;
    private final Function<MemeEntity, MemeDto> memeDtoMapper;

    @Override
    @Transactional
    public MemeDto uploadMeme(MultipartFile file, String source) {
        // Generate unique object name
        String objectName = generateObjectName(file.getOriginalFilename());

        // Upload file to MinIO
        String bucketPath = s3Service.uploadFile(
                "meme",
                objectName,
                file
        );

        // Create meme entity
        MemeModel memeModel = new MemeModel(bucketPath, source, file.getOriginalFilename());
        MemeEntity memeEntity = memeMapper.apply(memeModel);
        repository.save(memeEntity);
        return memeDtoMapper.apply(memeEntity);
    }

    @Override
    public Collection<MemeDto> findAll() {
        Account account = securityContextService.getAuthorizedAccount();

        return repository.findAllByAccount(account).stream()
                .map(memeDtoMapper)
                .toList();
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
}




