FROM navikt/java:15 as BUILDER

WORKDIR /app/build
COPY gradlew build.gradle.kts /app/build/
COPY gradle/ /app/build/gradle/
COPY src/ /app/build/src/

USER root
RUN ./gradlew shadowjar
RUN ./gradlew test

FROM navikt/java:15
LABEL org.opencontainers.image.source=https://github.com/navikt/kafka-skeleton

COPY --from=BUILDER /app/build/build/libs/app.jar /app/app.jar

CMD ["/app/app.jar"]
