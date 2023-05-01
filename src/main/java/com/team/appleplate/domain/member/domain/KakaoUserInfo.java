package com.team.appleplate.domain.member.domain;

import java.util.Map;

public class KakaoUserInfo implements OAuth2UserInfo {
    //카카오의 경우 providerId는 "id"로 가져옴

    private Map<String, Object> attributes;
    private Map<String, Object> attributesAccount;
    private Map<String, Object> attributesProfile;

    public KakaoUserInfo(Map<String, Object> attributes){
        this.attributes = attributes;
        this.attributesAccount = (Map<String, Object>)attributes.get("kakao_account");
        this.attributesProfile = (Map<String, Object>) attributesAccount.get("profile");
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getProviderId() {
        return attributes.get("id").toString();
    }

    @Override
    public String getProvider() {
        return "kakao";
    }

    @Override
    public String getEmail() {
        return attributesAccount.get("email").toString();
    }

    @Override
    public String getName() {
        String name = (String)attributesAccount.get("nickname");
        if(name == null){
            return "USER";
        }
         return name;
    }
}
