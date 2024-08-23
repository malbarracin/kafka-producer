# Usar una imagen base de Java
FROM eclipse-temurin:21-jre-alpine

# Crear un directorio en el contenedor
WORKDIR /app

# Copiar todos los JARs en el directorio de trabajo
COPY target/*.jar /app/

# Renombrar el JAR solo si el nombre es diferente
RUN for file in /app/*.jar; do \
    if [ "$file" != "/app/kafka-producer.jar" ]; then \
        mv "$file" /app/kafka-producer.jar; \
    fi; \
done

# Exponer el puerto en el que la aplicación escuchará
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/kafka-producer.jar"]