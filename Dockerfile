FROM openjdk:20
VOLUME [ "/tmp" ]
EXPOSE 8080
ADD ./target/backend.jar toybox_backend-aws.jar
ENTRYPOINT ["java", "-jar", "/toybox_backend-aws.jar"]

