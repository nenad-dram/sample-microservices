FROM openjdk:17-oracle

ARG LAYERS_DIR=target/layers

COPY ${LAYERS_DIR}/BOOT-INF/lib /discovery/lib
COPY ${LAYERS_DIR}/BOOT-INF/classes /discovery/classes
COPY ${LAYERS_DIR}/META-INF /discovery/META-INF

WORKDIR /discovery

EXPOSE  8761

ENTRYPOINT ["java","-cp","./classes:./lib/*","com.endyary.samplemicroservices.discovery.DiscoveryApplication"]
