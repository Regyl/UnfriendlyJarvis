package com.github.regyl.unfriendlyjarvis.service.impl.meme;

import com.github.regyl.unfriendlyjarvis.controller.dto.meme.MemeDto;
import com.github.regyl.unfriendlyjarvis.entity.MemeEntity;
import com.github.regyl.unfriendlyjarvis.service.s3.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class MemeEntityToMemeDtoMapperServiceImpl implements Function<MemeEntity, MemeDto> {

    private final S3Service s3Service;

    @Override
    public MemeDto apply(MemeEntity entity) {
        String presignedUri = s3Service.getPresignedUrl("meme", entity.getBucketPath());

        return MemeDto.builder()
                .presignedUri(presignedUri)
                .fileName(entity.getFileName())
                .id(entity.getId())
                .build();
    }
}
