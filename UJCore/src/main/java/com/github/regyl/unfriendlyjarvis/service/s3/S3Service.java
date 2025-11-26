package com.github.regyl.unfriendlyjarvis.service.s3;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * Service for working with MinIO object storage.
 */
public interface S3Service {

    /**
     * Upload file to MinIO bucket.
     *
     * @param bucketName bucket name
     * @param objectName object name (file path in bucket)
     * @param file       file to upload
     * @return path to the uploaded file in format: bucketName/objectName
     */
    String uploadFile(String bucketName, String objectName, MultipartFile file);

    /**
     * Get presigned URL for accessing file in MinIO.
     *
     * @param bucketName bucket name
     * @param objectName object name (file path in bucket)
     * @return presigned URL
     */
    String getPresignedUrl(String bucketName, String objectName);

    /**
     * Get file input stream from MinIO.
     *
     * @param bucketName bucket name
     * @param objectName object name (file path in bucket)
     * @return file input stream
     */
    InputStream getFile(String bucketName, String objectName);

    /**
     * Delete file from MinIO bucket.
     *
     * @param bucketName bucket name
     * @param objectName object name (file path in bucket)
     */
    void deleteFile(String bucketName, String objectName);
}

