package co.istad.chhaya.ecommerce.features.fileupload;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends
        JpaRepository<FileUpload, Integer> {
}
