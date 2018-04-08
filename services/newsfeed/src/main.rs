#![feature(plugin)]
#![plugin(rocket_codegen)]

extern crate rocket;
extern crate rocket_contrib;
#[macro_use] extern crate serde_derive;

use rocket_contrib::{Json};

mod newsfeed;
use newsfeed::{Newsfeed};
use newsfeed::{NewsItem};

#[get("/<user_id>")]
fn newsfeed(user_id: u64) -> Json<Newsfeed> {
    Json(
        Newsfeed { 
            user_id: user_id,
            news_items: vec![
                NewsItem {
                    id: 1,
                    title: "First news item".to_string()
                }
            ]
        }
    )
}

fn main() {
    rocket::ignite()
        .mount("/newsfeed", routes![newsfeed])
        .launch();
}
