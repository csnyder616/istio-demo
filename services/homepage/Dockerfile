FROM maven:3.5-jdk-10
WORKDIR /usr/src/app

COPY . .
RUN mvn clean install

EXPOSE 8080

CMD java -jar target/app.jar

