FROM openjdk:17-oracle

ARG LAYERS_DIR=target/layers

COPY ${LAYERS_DIR}/BOOT-INF/lib /employee/lib
COPY ${LAYERS_DIR}/BOOT-INF/classes /employee/classes
COPY ${LAYERS_DIR}/META-INF /employee/META-INF

WORKDIR /employee

EXPOSE  8080

ENTRYPOINT ["java","-cp","./classes:./lib/*","com.endyary.samplemicroservices.employee.EmployeeApplication"]
