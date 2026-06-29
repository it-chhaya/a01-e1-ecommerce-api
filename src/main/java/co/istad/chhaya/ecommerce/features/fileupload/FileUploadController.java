package co.istad.chhaya.ecommerce.features.fileupload;

import co.istad.chhaya.ecommerce.features.fileupload.dto.FileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUploadService fileUploadService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/multiple")
    public List<FileResponse> uploadMultiple(
            @RequestPart List<MultipartFile> files
    ) {
        return fileUploadService.uploadMultiple(files);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public FileResponse upload(@RequestPart MultipartFile file) {
        return  fileUploadService.upload(file);
    }

}
