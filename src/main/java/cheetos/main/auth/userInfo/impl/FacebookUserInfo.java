package cheetos.main.auth.userInfo.impl;

import cheetos.main.auth.userInfo.OAuth2UserInfo;

import java.util.Map;

public class FacebookUserInfo extends OAuth2UserInfo {

    public FacebookUserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getId() {
        return attributes.get("id").toString();
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }
}

