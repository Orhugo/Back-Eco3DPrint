package Eco3DPrint.BackendEco3DPrint.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

@Configuration
public class StorageConfig {
    private String accessKey = "";

    private String secretKey = "";

    private String region = "eu-west-3";

    @Bean
    public AmazonS3 generateS3Client(){
        try {
            // Lee el archivo JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("src/main/resources/credentials.json"));

            // Accede al valor del atributo "key"
            accessKey = jsonNode.get("access-key").asText();
            secretKey = jsonNode.get("secret-key").asText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        AWSCredentials credentials = new BasicAWSCredentials(accessKey,secretKey);
        return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(region).build();
    }

}
