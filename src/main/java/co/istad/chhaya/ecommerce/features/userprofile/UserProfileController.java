package co.istad.chhaya.ecommerce.features.userprofile;

import co.istad.chhaya.ecommerce.features.userprofile.dto.PatchUserProfileRequest;
import co.istad.chhaya.ecommerce.features.userprofile.dto.UserProfileResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-profiles")
@RequiredArgsConstructor
@SecurityRequirement(name = "keycloak")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PatchMapping("/me")
    public UserProfileResponse patchUserProfile(
            @Valid @RequestBody PatchUserProfileRequest patchUserProfileRequest
            ) {
        return userProfileService.patchUserProfile(patchUserProfileRequest);
    }


    @GetMapping("/me")
    public UserProfileResponse getUserProfile() {
        return userProfileService.getUserProfile();
    }

}
