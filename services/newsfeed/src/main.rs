#![feature(plugin)]
#![plugin(rocket_codegen)]

extern crate rocket;

#[get("/<user_id>")]
fn newsfeed(user_id: u64) -> String {
    format!("Hello, user {}!", user_id)
}

fn main() {
    rocket::ignite()
        .mount("/newsfeed", routes![newsfeed])
        .launch();
}
