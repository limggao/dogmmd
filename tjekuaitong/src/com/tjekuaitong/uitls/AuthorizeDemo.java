package com.tjekuaitong.uitls;
import com.qianmi.open.api.ApiException;
import com.qianmi.open.api.response.TokenResponse;
import com.qianmi.open.api.tool.util.OAuthUtils;
import com.qianmi.open.api.tool.util.QianmiContext;

public class AuthorizeDemo {

    /**
     * 根据授权码获取token
     * @param appKey
     * @param appSecret
     * @param code
     * @return
     * @throws ApiException
     */
    public static String getToken(String appKey, String appSecret, String code) throws ApiException {
        QianmiContext context = OAuthUtils.getToken(appKey, appSecret, code);
        TokenResponse response = context.getTokenResponse();
        String accessToken = response.getAccessToken();
        return accessToken;
    }

    /**
     * 根据refreshToken刷新token
     * @param appKey
     * @param appSecret
     * @param refreshToken
     * @return
     * @throws ApiException
     */
    public static String refreshToken(String appKey, String appSecret, String refreshToken) throws ApiException {
        QianmiContext context = OAuthUtils.refreshToken(appKey, appSecret, refreshToken);
        TokenResponse response = context.getTokenResponse();
        String accessToken = response.getAccessToken();
        return accessToken;
    }

    
}