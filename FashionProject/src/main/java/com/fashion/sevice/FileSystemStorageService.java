package com.fashion.sevice;



import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemStorageService implements StorageService {
    
    private final Path rootLocation;

    public FileSystemStorageService() {
        this.rootLocation = Paths.get("src/main/resources/static/uploads");
    }

    public void store(MultipartFile file) {
    	try {
			Path destrinationFile = this.rootLocation.resolve(
					Paths.get(file.getOriginalFilename()))
					.normalize().toAbsolutePath();
			try (InputStream inputStream  = file.getInputStream()) {
				Files.copy(inputStream, destrinationFile
						,StandardCopyOption.REPLACE_EXISTING);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
        
    }

    

    public void init() {
    	try {
			Files.createDirectories(rootLocation);
		} catch (Exception e) {
			// TODO: handle exception
		}
        
    }
}
