package co.istad.chhaya.ecommerce.features.userprofile;

import co.istad.chhaya.ecommerce.features.userprofile.dto.UserProfileResponse;
import org.keycloak.representations.idm.UserRepresentation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserProfileMapper {

    public UserProfileResponse buildUserProfileResponse(
            UserRepresentation userRepresentation,
            UserProfile userProfile
    ) {
        return UserProfileResponse.builder()
                .userId(userRepresentation.getId())
                .firstName(userRepresentation.getFirstName())
                .lastName(userRepresentation.getLastName())
                .email(userRepresentation.getEmail())
                .gender(userRepresentation.getAttributes().get("gender").getFirst())
                .biography(userRepresentation.getAttributes().get("biography").getFirst())
                .profilePicture(userProfile.getProfilePicture())
                .phoneNumber(userProfile.getPhoneNumber())
                .jobTitle(userProfile.getJobTitle())
                .salary(userProfile.getSalary())
                .facebookLink(userProfile.getFacebookLink())
                .githubLink(userProfile.getGithubLink())
                .build();
    }

}
