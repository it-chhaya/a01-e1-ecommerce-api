package co.istad.chhaya.ecommerce.features.userprofile;

import co.istad.chhaya.ecommerce.features.userprofile.dto.UserProfileResponse;
import co.istad.chhaya.ecommerce.security.AuthUtils;
import co.istad.chhaya.ecommerce.security.KeycloakProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserProfileMapper userProfileMapper;
    private final Keycloak keycloak;
    private final KeycloakProperties keycloakProps;

    @Override
    public UserProfileResponse getUserProfile() {
        // Get user profile from keycloak
        String userId = AuthUtils.extractUserId();
        UserResource userResource = keycloak.realm(keycloakProps.getRealm())
                .users()
                .get(userId);
        UserRepresentation userRepresentation = userResource.toRepresentation();
        log.info("user profile: {}", userRepresentation);

        // Get user profile from database
        UserProfile userProfile = userProfileRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "User profile has not been found"
                ));

        return userProfileMapper.buildUserProfileResponse(userRepresentation, userProfile);
    }

}
