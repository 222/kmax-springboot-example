# 使用官方 OpenJDK 8 的基础镜像
FROM openjdk:8-jdk-alpine

# 设置工作目录
WORKDIR /app

# 将本地 JAR 文件复制到镜像中
COPY target/*.jar app.jar

# 声明环境变量
ENV TZ=Asia/Shanghai JAVA_OPTS="-Xms512m -Xmx512m"
ENV SPRING_PROFILES_ACTIVE="docker"

# 暴露应用运行的端口（根据项目的配置修改端口）
EXPOSE 8080

# 定义容器启动时运行的命令
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE -jar /app/app.jar"]
