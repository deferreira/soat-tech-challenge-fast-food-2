# Etapa 1: build com Maven
FROM maven:3.9.7-eclipse-temurin-21-alpine AS build

WORKDIR /app
RUN pwd
COPY pom.xml ./
COPY src ./src

#RUN mvn clean package -DskipTests
RUN mvn package

# Etapa 2: imagem final com JAR leve
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Cria um argumento para o nome da aplicação
ARG JAR_FILE=target/*.jar

COPY --from=build /app/${JAR_FILE} app.jar
#COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]