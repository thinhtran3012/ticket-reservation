# Extend qcdatainc/centos-jdk image
FROM java:8-jre
ENV HOME /opt/target

WORKDIR $HOME

ARG PROJECT_VER=0.1.0
ENV EXEC_FILE ticket-reservation-${PROJECT_VER}-fat.jar
#
EXPOSE 9100
# Copy your verticle to the container
COPY target/bin/$EXEC_FILE $HOME/$EXEC_FILE
# Launch the verticle
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $EXEC_FILE"]