FROM rustlang/rust:nightly

WORKDIR /usr/src/newsfeed
COPY . .

RUN cargo install

ENV ROCKET_ENV=production

CMD ["newsfeed"]
