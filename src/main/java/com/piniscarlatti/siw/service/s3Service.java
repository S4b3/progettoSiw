package com.piniscarlatti.siw.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Service
public class s3Service {

    private AWSCredentials credentials;

    private AmazonS3 s3client;

    private String endpointUrl;

    private String bucketName;

    private String accessKey;

    private String secretKey;

    public s3Service() {
        setProperties();
        this.credentials = new BasicAWSCredentials(accessKey, secretKey);
        this.s3client  = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.EU_CENTRAL_1)
                .build();
    }

    public AmazonS3 getS3Client(){
        return s3client;
    }

    private void setProperties() {
        try (InputStream input = s3Service.class.getClassLoader().getResourceAsStream("aws.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            this.accessKey = prop.getProperty("aws.access.key");
            this.secretKey = prop.getProperty("aws.access.secret");
            this.endpointUrl = prop.getProperty("aws.endpoint.url");
            this.bucketName = prop.getProperty("aws.bucket.name");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
