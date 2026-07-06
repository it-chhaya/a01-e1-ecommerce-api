package co.istad.chhaya.ecommerce.features.auth;

import co.istad.chhaya.ecommerce.features.auth.dto.RegisterRequest;
import co.istad.chhaya.ecommerce.features.auth.dto.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final Keycloak keycloak;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {

        // Validate password
        if (!registerRequest.password().equals(
                registerRequest.confirmedPassword()
        )) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Passwords do not match");
        }

        return null;
    }

}
