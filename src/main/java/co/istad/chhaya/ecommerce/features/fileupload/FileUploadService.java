package co.istad.chhaya.ecommerce.features.fileupload;

import co.istad.chhaya.ecommerce.features.fileupload.dto.FileResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileUploadService {

    List<FileResponse> uploadMultiple(List<MultipartFile> files);

    FileResponse upload(MultipartFile file);

}
