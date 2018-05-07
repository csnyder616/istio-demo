package com.snyder616.istiodemo.homepage;

import com.snyder616.istiodemo.newsfeed.api.NewsfeedApi;
import com.snyder616.istiodemo.userinfo.ApiClient;
import com.snyder616.istiodemo.userinfo.api.UserInfoApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
  @Value("${user-info.url}")
  private String userInfoUrl;
  @Value("${newsfeed.url}")
  private String newsfeedUrl;

  @Bean
  public UserInfoApi userInfoApi() {
    ApiClient apiClient = new ApiClient();
    apiClient.setBasePath(userInfoUrl);
    return new UserInfoApi(apiClient);
  }

  @Bean
  public NewsfeedApi newsfeedApi() {
    com.snyder616.istiodemo.newsfeed.ApiClient apiClient = new com.snyder616.istiodemo.newsfeed.ApiClient();
    apiClient.setBasePath(newsfeedUrl);
    return new NewsfeedApi(apiClient);
  }
}
