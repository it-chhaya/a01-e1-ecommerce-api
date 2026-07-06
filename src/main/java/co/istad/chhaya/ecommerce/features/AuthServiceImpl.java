package co.istad.chhaya.ecommerce.features;

import co.istad.chhaya.ecommerce.features.auth.AuthService;
import co.istad.chhaya.ecommerce.features.auth.dto.RegisterRequest;
import co.istad.chhaya.ecommerce.features.auth.dto.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final Keycloak keycloak;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        IO.println("keycloak: " + keycloak);
        return null;
    }

}
