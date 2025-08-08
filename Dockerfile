# Step 1: Use an OpenJDK image
FROM openjdk:17-jdk-slim

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy Maven build output (JAR file) to container
COPY target/loginapp-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Run the app
ENTRYPOINT ["java","-jar","app.jar"]
