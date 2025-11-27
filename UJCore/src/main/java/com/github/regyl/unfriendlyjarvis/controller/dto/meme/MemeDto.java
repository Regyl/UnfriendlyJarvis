package com.github.regyl.unfriendlyjarvis.controller.dto.meme;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemeDto {

    private String presignedUri;
    private String fileName;
    private Long id;
}
