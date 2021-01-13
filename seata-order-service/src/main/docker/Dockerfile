FROM java:8
VOLUME /tmp
ADD seata-order-service-0.0.1-SNAPSHOT.jar order.jar
EXPOSE 8083
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/order.jar"]
# 指定维护者的名字
MAINTAINER lk