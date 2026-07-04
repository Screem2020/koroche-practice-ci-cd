# --- Этап 1: сборка jar через JDK ---
FROM eclipse-temurin:25-jdk AS build
WORKDIR /workspace

# Сначала копируем только gradle-обвязку для кеширования зависимостей
COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle.kts settings.gradle.kts ./
RUN chmod +x gradlew && ./gradlew --no-daemon dependencies || true

# Копируем исходники и собираем исполняемый jar
COPY src ./src
RUN ./gradlew --no-daemon clean bootJar

# --- Этап 2: запуск через JRE ---
FROM eclipse-temurin:25-jre AS runtime
WORKDIR /app

# Копируем собранный boot-jar (без -plain варианта)
COPY --from=build /workspace/build/libs/*-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
