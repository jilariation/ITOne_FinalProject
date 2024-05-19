# Используем базовый образ с Java
FROM openjdk:17-jdk-slim

# Устанавливаем аргумент с именем JAR-файла (по умолчанию - app.jar)
ARG JAR_FILE=itonefinalproject-0.0.1-SNAPSHOT.jar

# Устанавливаем точку назначения для приложения
WORKDIR /app

# Копируем собранный JAR-файл приложения в контейнер
COPY build/libs/${JAR_FILE} app.jar

# Определяем порт, который будет прослушивать приложение
EXPOSE 8080

# Команда для запуска приложения
CMD ["java", "-jar", "app.jar"]