FROM openjdk:17-oracle

ARG LAYERS_DIR=target/layers

COPY ${LAYERS_DIR}/BOOT-INF/lib /gateway/lib
COPY ${LAYERS_DIR}/BOOT-INF/classes /gateway/classes
COPY ${LAYERS_DIR}/META-INF /gateway/META-INF

WORKDIR /gateway

EXPOSE  8070

ENTRYPOINT ["java","-cp","./classes:./lib/*","com.endyary.samplemicroservices.gateway.GatewayApplication"]
