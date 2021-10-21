FROM adoptopenjdk:8-jre-hotspot

EXPOSE 8080

ADD build/libs/laptop-shop-0.0.1-SNAPSHOT.jar laptop-shop-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","laptop-shop-0.0.1-SNAPSHOT.jar"]