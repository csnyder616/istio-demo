package com.snyder616.istiodemo.homepage;

import com.snyder616.istiodemo.userinfo.ApiClient;
import com.snyder616.istiodemo.userinfo.api.UserInfoApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
  @Value("${user-info.url}")
  private String userInfoUrl;

  @Bean
  public UserInfoApi userInfoApi() {
    ApiClient apiClient = new ApiClient();
    apiClient.setBasePath(userInfoUrl);
    return new UserInfoApi(apiClient);
  }
}
