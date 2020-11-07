# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="Paathshala"

ENV APP_HOME=/usr/app/

ENV JAR_FILE=build/libs/flight-service-0.0.1-SNAPSHOT.jar

WORKDIR $APP_HOME

#COPY build.gradle settings.gradle gradlew $APP_HOME
#COPY gradle $APP_HOME/gradle
#RUN ./gradlew build

COPY . $APP_HOME

RUN chmod +x gradlew

RUN ./gradlew build

RUN mv build/libs/flight-service-0.0.1-SNAPSHOT.jar flight-service.jar 

# Add a volume pointing to /tmp
#VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
#ARG JAR_FILE=build/libs/flight-service-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
#ADD ${JAR_FILE} flight-service.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","flight-service.jar"]