package co.istad.chhaya.ecommerce.features.fileupload;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileUploadRepository extends
        JpaRepository<FileUpload, Integer> {

    Optional<FileUpload> findByName(String name);

}
