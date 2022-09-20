package cheetos.main.auth.service;

import cheetos.main.auth.domain.PrincipalDetails;
import cheetos.main.auth.userInfo.*;
import cheetos.main.user.User;
import cheetos.main.user.domain.Email;
import cheetos.main.user.domain.Role;
import cheetos.main.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    @Autowired private UserRepository userRepository;

    // userRequest 정보 -> loadUser 함수 호출 -> 회원 프로필 정보 받아옴
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);

        OAuth2UserInfo oAuth2UserInfo = null;
        String provider = userRequest.getClientRegistration().getRegistrationId();

        if (provider.equals("google")) {
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        }else if (provider.equals("facebook")){
            oAuth2UserInfo = new FacebookUserInfo(oAuth2User.getAttributes());
        }else if (provider.equals("naver")) {
            oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response"));
        }else if (provider.equals("kakao")) {
            oAuth2UserInfo = new KakaoUserInfo(oAuth2User.getAttributes());
        }

        String username = oAuth2UserInfo.getName();
        String email = oAuth2UserInfo.getEmail();

        User byUsername = userRepository.findByEmail(new Email(email));
        Role role = Role.USER;

        if(byUsername == null) {
            byUsername = User.oauth2Register()
                    .nickName(username).email(email).role(role)
                    .authProvider(provider)
                    .build();
            userRepository.save(byUsername);
        }
        return new PrincipalDetails(byUsername, oAuth2UserInfo);
    }
}
