From openjdk:latest
COPY target/demo-0.0.1-SNAPSHOT.jar /user/src/demo-0.0.1-SNAPSHOT.jar

#CMD java -jar /user/src/demo-0.0.1-SNAPSHOT.jar
RUN sudo sysctl -w vm.max_map_count=262144
ENV TZ=Europe/Berlin
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
