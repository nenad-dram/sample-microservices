FROM openjdk:17-oracle

ARG LAYERS_DIR=target/layers

COPY ${LAYERS_DIR}/BOOT-INF/lib /organization/lib
COPY ${LAYERS_DIR}/BOOT-INF/classes /organization/classes
COPY ${LAYERS_DIR}/META-INF /organization/META-INF

WORKDIR /organization

EXPOSE  8082

ENTRYPOINT ["java","-cp","./classes:./lib/*","com.endyary.samplemicroservices.organization.OrganizationApplication"]
