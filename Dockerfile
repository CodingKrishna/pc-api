FROM adoptopenjdk/openjdk8:latest
ADD ./target/pioneercoders-0.0.1-SNAPSHOT.jar /pioneercoders.jar
ADD ./run.sh /run.sh
RUN chmod a+x /run.sh
EXPOSE 8080:8080
CMD /run.sh