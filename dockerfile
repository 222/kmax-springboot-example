FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/*.jar app.jar
ENV TZ=Asia/Shanghai JAVA_OPTS="-Xms512m -Xmx512m"
ENV SPRING_PROFILES_ACTIVE="docker"
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE -jar /app/app.jar"]