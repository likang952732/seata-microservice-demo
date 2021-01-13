FROM java:8
VOLUME /tmp
ADD seata-product-service-0.0.1-SNAPSHOT.jar product.jar
EXPOSE 8082
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/product.jar"]
# 指定维护者的名字
MAINTAINER lk