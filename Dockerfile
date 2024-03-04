FROM openjdk:17-jdk-slim AS build

VOLUME /tmp

ARG DEPENDENCY=/workspace/app/target/dependency

COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app


RUN chmod -R 777 ./mvnw

RUN ./mvnw install -DskipTests

RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)


COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src


ENTRYPOINT ["java","-cp","app:app/lib/*","com.restful.triagil.challenge"]