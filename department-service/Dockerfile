FROM openjdk:17-oracle

ARG LAYERS_DIR=target/layers

COPY ${LAYERS_DIR}/BOOT-INF/lib /department/lib
COPY ${LAYERS_DIR}/BOOT-INF/classes /department/classes
COPY ${LAYERS_DIR}/META-INF /department/META-INF

WORKDIR /department

EXPOSE  8081

ENTRYPOINT ["java","-cp","./classes:./lib/*","com.endyary.samplemicroservices.department.DepartmentApplication"]
