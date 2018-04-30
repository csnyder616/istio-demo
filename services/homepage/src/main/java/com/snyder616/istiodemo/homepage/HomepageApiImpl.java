package com.snyder616.istiodemo.homepage;

import com.snyder616.istiodemo.homepage.api.HomepageApi;
import com.snyder616.istiodemo.homepage.model.Homepage;
import com.snyder616.istiodemo.homepage.model.UserInfo;
import com.snyder616.istiodemo.userinfo.api.UserInfoApi;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomepageApiImpl implements HomepageApi {
  private final UserInfoApi userInfoApi;

  @Autowired
  public HomepageApiImpl(UserInfoApi userInfoApi) {
    this.userInfoApi = userInfoApi;
  }

  @Override
  public ResponseEntity<Homepage> getHomepageById(@ApiParam(value = "ID of user for which to retrieve homepage",required=true) @PathVariable("userId") Long userId) {
    System.out.println("\n\n\nuserId = [" + userId + "]\n\n\n");
    com.snyder616.istiodemo.userinfo.model.UserInfo userInfo = userInfoApi.getUserInfoById(userId);

    Homepage homepage = new Homepage();
    UserInfo homepageUserInfo = new UserInfo();
    homepage.setUser(homepageUserInfo);
    homepageUserInfo.id(userInfo.getId()).name(userInfo.getName());
    return ResponseEntity.ok(homepage);
  }
}
