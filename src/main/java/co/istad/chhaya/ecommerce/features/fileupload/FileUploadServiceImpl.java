package co.istad.chhaya.ecommerce.features.fileupload;

import co.istad.chhaya.ecommerce.features.fileupload.dto.FileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {

    private final FileUploadRepository fileUploadRepository;
    private final FileUploadMapper fileUploadMapper;

    @Value("${file-upload.server-path}")
    private String serverPath;


    @Override
    public Page<FileResponse> findAll(int pageNumber, int pageSize) {
        Sort sortById = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sortById);

        Page<FileUpload> fileUploadPage = fileUploadRepository.findAll(pageable);

        return fileUploadPage
                .map(fileUploadMapper::mapFileUploadToFileResponse);
    }


    @Override
    public FileResponse findByName(String name) {
        return fileUploadRepository
                .findByName(name)
                .map(fileUploadMapper::mapFileUploadToFileResponse)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "File has not been found"
                ));
    }


    @Override
    public List<FileResponse> uploadMultiple(List<MultipartFile> files) {
        return files.stream()
                .map(this::saveFile)
                .collect(Collectors.toList());
    }


    @Override
    public FileResponse upload(MultipartFile file) {
        return saveFile(file);
    }


    private FileResponse saveFile(MultipartFile file) {
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

        return fileUploadMapper.mapFileUploadToFileResponse(fileUpload);
    }

}
