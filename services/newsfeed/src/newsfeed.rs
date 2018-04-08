#[derive(Serialize, Deserialize)]
pub struct Newsfeed {
  pub user_id: u64,
  pub news_items: Vec<NewsItem>
}

#[derive(Serialize, Deserialize)]
pub struct NewsItem {
  pub id: u64,
  pub title: String
}
