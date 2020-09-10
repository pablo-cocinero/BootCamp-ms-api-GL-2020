FROM openjdk:8
ARG JAR_FILE=Customer-shop/target/Customer-shop-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} Customer-shop-0.0.1-SNAPSHOT.jar
RUN apt-get update
RUN apt-get upgrade
RUN apt-get install curl
ENTRYPOINT ["java","-jar","/Customer-shop-0.0.1-SNAPSHOT.jar"]