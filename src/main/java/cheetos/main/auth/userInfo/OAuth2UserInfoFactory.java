package cheetos.main.auth.userInfo;

import cheetos.main.auth.userInfo.impl.FacebookUserInfo;
import cheetos.main.auth.userInfo.impl.GoogleUserInfo;
import cheetos.main.auth.userInfo.impl.KakaoUserInfo;
import cheetos.main.auth.userInfo.impl.NaverUserInfo;
import cheetos.main.user.domain.Provider;

import java.util.Map;

public class OAuth2UserInfoFactory {
    public static OAuth2UserInfo getOAuth2UserInfo(Provider provider, Map<String, Object> attributes) {
        switch (provider) {
            case GOOGLE: return new GoogleUserInfo(attributes);
            case FACEBOOK: return new FacebookUserInfo(attributes);
            case NAVER: return new NaverUserInfo(attributes);
            case KAKAO: return new KakaoUserInfo(attributes);
            default: throw new IllegalArgumentException("Invalid Provider Type.");
        }
    }
}
