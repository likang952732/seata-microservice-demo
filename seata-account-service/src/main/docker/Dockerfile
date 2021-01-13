FROM java:8
VOLUME /tmp
ADD seata-account-service-0.0.1-SNAPSHOT.jar account.jar
EXPOSE 8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/account.jar"]
# 指定维护者的名字
MAINTAINER lk