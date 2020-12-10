FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
MAINTAINER bswenapp@gmail.com
ENV APPROOT="/opt/app7"
ARG DEPENDENCY=build/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib ${APPROOT}/lib
COPY ${DEPENDENCY}/META-INF ${APPROOT}/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes ${APPROOT}

ENTRYPOINT ["java","-XX:OnOutOfMemoryError=\"kill -9 %p\"","-Djava.security.egd=file:/dev/./urandom","-cp","/opt/app7:/opt/app7/lib/*","-Droot.dir=/opt/app7","com.bswen.app7.Main"]
EXPOSE 8082