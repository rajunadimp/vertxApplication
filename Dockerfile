FROM sgrio/java-oracle
MAINTAINER Raju
RUN apt-get update
RUN apt-get install -y maven
ADD pom.xml /usr/local/docker/pom.xml
ADD src /usr/local/docker/src
WORKDIR /usr/local/docker
RUN mvn package
CMD ["java","-jar","target/docker-service-1.0-SNAPSHOT.jar"]
