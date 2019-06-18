package com.piniscarlatti.siw.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@Service
public class ImageStorageService {

    private static final Logger logger = LoggerFactory.getLogger("logger");


    @Autowired
    private s3Service s3Service;

    private static final String BUCKET_NAME = "siwpics";
    private static final long MAX_SIZE = 5000000;
    public ImageStorageService() {

    }



    public String storeImage(MultipartFile file) {
        AmazonS3 s3client = s3Service.getS3Client();
        logger.info("Loggo il client dentro storservice " + s3client.toString());
        try {
            InputStream is = file.getInputStream();
            if(file.getSize()>MAX_SIZE)
                return "SIZE EXCEEDED"; //8536900 = 8500kB = 8.5mB
            //store s3 file
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("image");

            String s3ObjectKey = this.generateFileName(file);
            s3client.putObject(new PutObjectRequest(BUCKET_NAME, s3ObjectKey, is,metadata).withCannedAcl(CannedAccessControlList.PublicRead));
            S3Object s3Object = s3client.getObject(new GetObjectRequest(BUCKET_NAME,s3ObjectKey));
            String picUrl = s3Object.getObjectContent().getHttpRequest().getURI().toString();
            return picUrl;
        }
        catch(IOException e) {
            e.printStackTrace();
            return "COULDNT DO IT RIP";
        }

    }
    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }

}