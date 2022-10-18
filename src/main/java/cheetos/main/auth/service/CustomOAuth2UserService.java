package cheetos.main.auth.service;

import cheetos.main.auth.domain.UserPrincipal;
import cheetos.main.auth.exception.OAuthProviderMissMatchException;
import cheetos.main.auth.userInfo.*;
import cheetos.main.user.domain.Provider;
import cheetos.main.user.domain.User;
import cheetos.main.user.domain.Email;
import cheetos.main.user.domain.Role;
import cheetos.main.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    // userRequest 정보 -> loadUser 함수 호출 -> 회원 프로필 정보 받아옴
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        try {
            return this.process(userRequest, oAuth2User);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalAuthenticationServiceException(e.getMessage(), e.getCause());
        }
    }

    private OAuth2User process(OAuth2UserRequest userRequest, OAuth2User user) {
        Provider provider = Provider.valueOf(userRequest.getClientRegistration().getRegistrationId().toUpperCase());

        OAuth2UserInfo userInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(provider, user.getAttributes());

        Email email = new Email(userInfo.getEmail());
        User savedUser = userRepository.findByEmail(email);

        // provider 가 다르다면 에러 던짐
        if (savedUser != null) {
            if (provider != savedUser.getAuthProvider()) {
                throw new OAuthProviderMissMatchException(
                        "Looks loke you're signed up with " + provider +
                        " account. Please use your " + savedUser.getAuthProvider() + "account to login."
                );
            }
            updateUser(savedUser, userInfo);
        } else {
            savedUser = createUser(userInfo, provider);
        }

        return UserPrincipal.create(savedUser, user.getAttributes());
    }

    private User createUser(OAuth2UserInfo userInfo, Provider provider) {
        Role role = Role.USER;
        User user = User.oauth2Register()
                .nickName(userInfo.getName())
                .email(userInfo.getEmail())
                .role(role)
                .authProvider(provider)
                .build();

        return userRepository.save(user);
    }

    // 변경되는 유저 정보가 있다면 업데이트
    private User updateUser(User user, OAuth2UserInfo userInfo) {
        if (userInfo.getName() != null && !user.getNickName().equals(userInfo.getName())) {

        }

        return user;
    }
}
