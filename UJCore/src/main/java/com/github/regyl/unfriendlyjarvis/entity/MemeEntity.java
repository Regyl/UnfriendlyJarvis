package com.github.regyl.unfriendlyjarvis.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Entity for storing meme metadata.
 * Images are stored in MinIO, only reference to bucket path is stored here.
 */
@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "e_meme")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class MemeEntity extends AbstractEntity {

    /**
     * Account owner of the meme.
     */
    @NotNull
    private Long accountId;

    /**
     * Path to the image file in MinIO bucket.
     * Format: bucket-name/object-key
     */
    @NotBlank
    @Column(name = "bucket_path", nullable = false)
    private String bucketPath;

    @NotBlank
    @Column(name = "file_name", nullable = false)
    private String fileName;
}
