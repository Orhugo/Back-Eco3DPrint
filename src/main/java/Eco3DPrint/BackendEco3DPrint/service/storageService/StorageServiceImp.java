package Eco3DPrint.BackendEco3DPrint.service.storageService;

import Eco3DPrint.BackendEco3DPrint.config.StorageConfig;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class StorageServiceImp implements StorageService{
    private String bucketName= "stl-models-bucket";
    private StorageConfig storageConfig = new StorageConfig();
    @Autowired
    private AmazonS3 s3Client;

    @Override
    public String uploadFile(MultipartFile file){
        File fileObj = convertMultiPartFileToFile(file);
        String fileName = System.currentTimeMillis()+"_"+file.getOriginalFilename();
        s3Client.putObject(new PutObjectRequest(bucketName,fileName,fileObj));
        fileObj.delete();
        return "File uploaded " + fileName;
    }

    @Override
    public byte[] downloadFile(String fileName){
        S3Object s3Object =  s3Client.getObject(bucketName,fileName);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        try {
            byte[] content = IOUtils.toByteArray(inputStream);
            return content;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String deleteFile(String fileName){
        s3Client.deleteObject(bucketName,fileName);
        return "File deleted: " + fileName;
    }

    @Override
    public String getFileUrl(String key) {
        return s3Client.getUrl(bucketName, key).toString();
    }

    private File convertMultiPartFileToFile(MultipartFile file){
        File convertedFile = new File(file.getOriginalFilename());
        try(FileOutputStream fos = new FileOutputStream(convertedFile)){
            fos.write(file.getBytes());
        }catch(IOException e){
            System.out.println("Error converting multipart file to file");
        }
        return convertedFile;
    }
}
