package Eco3DPrint.BackendEco3DPrint.service.storageService;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    public String uploadFile(MultipartFile file);
    public byte[] downloadFile(String fileName);
    public String deleteFile(String fileName);
    public String getFileUrl(String key);
}
