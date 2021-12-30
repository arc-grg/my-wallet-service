FROM openjdk:8
ADD target/wallet-for-docker.war /wallet-for-docker.war
EXPOSE 8085
ENTRYPOINT ["java","-war","wallet-for-docker.war"]