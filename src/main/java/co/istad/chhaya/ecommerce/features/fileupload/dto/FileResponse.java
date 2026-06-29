package co.istad.chhaya.ecommerce.features.fileupload.dto;

import lombok.Builder;

@Builder
public record FileResponse(
        String name,
        Long size,
        String mediaType,
        String uri
) {
}
