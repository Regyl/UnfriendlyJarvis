package com.github.regyl.unfriendlyjarvis.service.meme;

import com.github.regyl.unfriendlyjarvis.entity.MemeEntity;
import com.github.regyl.unfriendlyjarvis.service.CrudService;
import org.springframework.web.multipart.MultipartFile;

/**
 * Service for working with memes.
 */
public interface MemeService extends CrudService<MemeEntity> {

    /**
     * Upload meme image and save metadata.
     *
     * @param file   meme image file
     * @param source optional source of the meme
     * @return saved meme entity
     */
    MemeEntity uploadMeme(MultipartFile file, String source);
}

