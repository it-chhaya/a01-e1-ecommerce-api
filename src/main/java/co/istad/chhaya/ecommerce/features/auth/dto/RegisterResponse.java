package co.istad.chhaya.ecommerce.features.auth.dto;

public record RegisterResponse(
        String keycloakUserId,
        String username,
        String email,
        String firstName,
        String lastName,
        String gender,
        String biography
) {
}
