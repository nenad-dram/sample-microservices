FROM openjdk:17-oracle

ARG LAYERS_DIR=target/layers

COPY ${LAYERS_DIR}/BOOT-INF/lib /config/lib
COPY ${LAYERS_DIR}/BOOT-INF/classes /config/classes
COPY ${LAYERS_DIR}/META-INF /config/META-INF

WORKDIR /config

EXPOSE  8088

ENTRYPOINT ["java","-cp","./classes:./lib/*","com.endyary.samplemicroservices.config.ConfigApplication"]
