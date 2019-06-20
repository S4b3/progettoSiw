package com.piniscarlatti.siw.service;

import org.springframework.web.multipart.MultipartFile;

public interface AmazonClientInterface {
    String uploadFile(MultipartFile multipartFile);

    String deleteFileFromS3Bucket(String fileUrl);
}
