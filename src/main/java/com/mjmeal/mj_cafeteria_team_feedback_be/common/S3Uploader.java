package com.mjmeal.mj_cafeteria_team_feedback_be.common;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Uploader {

    private S3Client s3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.s3.folder}")
    private String folder;

    @PostConstruct
    public void init() {
        this.s3Client = S3Client.builder()
                .region(Region.AP_NORTHEAST_2)
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
    }

    public String upload(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        String extension = getExtension(originalFilename);
        String key = folder + UUID.randomUUID() + extension;

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucket)
                .key(key)
                .contentType(file.getContentType())
                .acl("public-read")
                .build();

        try {
            s3Client.putObject(request, RequestBody.fromBytes(file.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException("S3 업로드 실패", e);
        }

        return getFileUrl(key);
    }

    private String getExtension(String filename) {
        return filename.substring(filename.lastIndexOf("."));
    }

    private String getFileUrl(String key) {
        return "https://" + bucket + ".s3.ap-northeast-2.amazonaws.com/" + key;
    }
}