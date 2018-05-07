package com.snyder616.istiodemo.homepage;

import com.snyder616.istiodemo.homepage.api.HomepageApi;
import com.snyder616.istiodemo.homepage.model.Homepage;
import com.snyder616.istiodemo.homepage.model.HomepageNewsItem;
import com.snyder616.istiodemo.homepage.model.HomepageUserInfo;
import com.snyder616.istiodemo.newsfeed.api.NewsfeedApi;
import com.snyder616.istiodemo.newsfeed.model.Newsfeed;
import com.snyder616.istiodemo.userinfo.api.UserInfoApi;
import com.snyder616.istiodemo.userinfo.model.UserInfo;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HomepageApiImpl implements HomepageApi {
  private final UserInfoApi userInfoApi;
  private final NewsfeedApi newsfeedApi;

  @Autowired
  public HomepageApiImpl(UserInfoApi userInfoApi, NewsfeedApi newsfeedApi) {
    this.userInfoApi = userInfoApi;
    this.newsfeedApi = newsfeedApi;
  }

  @Override
  public ResponseEntity<Homepage> getHomepageById(@ApiParam(value = "ID of user for which to retrieve homepage",required=true) @PathVariable("userId") Long userId) {
    Homepage homepage = new Homepage();

    // retrieve user info
    UserInfo userInfo = userInfoApi.getUserInfoById(userId);
    if (userInfo == null) {
      return ResponseEntity.notFound().build();
    }
    HomepageUserInfo homepageUserInfo = new HomepageUserInfo();
    homepage.setUser(homepageUserInfo);
    homepageUserInfo
        .id(userId)
        .name(userInfo.getName());

    // retrieve newsfeed items
    Newsfeed newsfeed = newsfeedApi.getNewsfeedItemsByUserId(userId);
    if (newsfeed != null && newsfeed.getNewsItems() != null) {
      List<HomepageNewsItem> items = newsfeed.getNewsItems().stream().map(from -> {
        HomepageNewsItem to = new HomepageNewsItem();
        to
            .id(from.getId())
            .title(from.getTitle());
        return to;
      }).collect(Collectors.toList());
      homepage.setNewsItems(items);
    }

    return ResponseEntity.ok(homepage);
  }
}
