################################################################################

# Chọn nền tảng của openjdk 21 slim (image này khá nhẹ)
FROM openjdk:21-jdk-slim as deps

WORKDIR /apis

# Copy các cấu hình mvnw và pom trong api2 folder vào folder cùng tên ở docker
COPY --chmod=0755 mvnw mvnw
COPY .api2/mvn/ .api2/mvn/
COPY .api2/pom.xml .api2/pom.xml

# Download các dependency để nhận được vào trong Docker .cache
# Cache này chỉ download một lần tránh lặp lại
RUN --mount=type=cache,target=/root/.m2 .api2/mvnw dependency:go-offline -DskipTests

################################################################################

# Tiến hành build các application dựa trên những gì đã download từ dependency trên
FROM deps as package

WORKDIR /apis

# Copy toàn bộ source vào trong src
COPY .api2/ .api2/src/

# Build project và tạo ra 1 cái jar từ những dependency
RUN --mount=type=bind,source=/api2/pom.xml,target=/api2/pom.xml \
    --mount=type=cache,target=/root/.m2 \
    .api2/mvnw package -DskipTests && \
    mv target/$(.api2/mvnw help:evaluate -Dexpression=project.artifactId -q -DforceStdout)-$(.api2/mvnw help:evaluate -Dexpression=project.version -q -DforceStdout).jar apis/api.jar


################################################################################

FROM eclipse-temurin:21.0.4-jre-jammy AS final

WORKDIR /apis

# Create a non-privileged user that the app will run under.
# See https://docs.docker.com/go/dockerfile-user-best-practices/
ARG UID=10001
RUN adduser \
    --disabled-password \
    --gecos "" \
    --home "/nonexistent" \
    --shell "/sbin/nologin" \
    --no-create-home \
    --uid "${UID}" \
    appuser
USER appuser

# Copy the executable from the "package" stage.
COPY --from=package apis/api.jar /apis/api.jar

EXPOSE 5000

ENTRYPOINT [ "java", "-jar", "api.jar" ]
