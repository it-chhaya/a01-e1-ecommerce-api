# Understand Instruction
FROM ghcr.io/graalvm/jdk-community:25i1
WORKDIR /workspace
COPY build/libs/a01-e1-spring-webmvc-1.0.jar /workspace/api.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "/workspace/api.jar"]