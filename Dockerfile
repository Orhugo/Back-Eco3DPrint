# Utiliza una imagen base con Java 17
FROM openjdk:17-alpine

# Define el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR de tu aplicación al contenedor
COPY build/libs/Backend-Eco3DPrint-0.0.1-SNAPSHOT.jar /app/app.jar

# Expone el puerto en el que tu aplicación Spring Boot escucha (por defecto, el puerto 8080)
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot
CMD ["java", "-jar", "app.jar"]