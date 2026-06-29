package co.istad.chhaya.ecommerce.features.fileupload;

import co.istad.chhaya.ecommerce.features.fileupload.dto.FileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {

    private final FileUploadRepository fileUploadRepository;

    @Value("${file-upload.server-path}")
    private String serverPath;

    @Value("${file-upload.base-uri}")
    private String baseUri;

    @Override
    public FileResponse upload(MultipartFile file) {

        String fileName = UUID.randomUUID().toString();
        String fileExt = file.getOriginalFilename()
                .substring(file.getOriginalFilename().lastIndexOf(".") + 1);

        // Create path object
        Path path = Paths.get(String.format("%s%s.%s", serverPath, fileName, fileExt));
        try {
            Files.copy(file.getInputStream(), path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FileUpload fileUpload = new FileUpload();
        fileUpload.setName(fileName);
        fileUpload.setExtension(fileExt);
        fileUpload.setMediaType(file.getContentType());
        fileUpload.setSize(file.getSize());

        fileUploadRepository.save(fileUpload);

        return FileResponse.builder()
                .name(fileUpload.getName())
                .extension(fileUpload.getExtension())
                .mediaType(fileUpload.getMediaType())
                .size(fileUpload.getSize())
                .uri(baseUri + "/" + fileUpload.getName() + "." +  fileUpload.getExtension())
                .build();
    }

}
