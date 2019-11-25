# Dockerfile

#Imagen ubuntu creada a partir de phusion/baseimage:0.11
FROM  zirtrex/ubuntu-java-tomcat-mysql:latest

MAINTAINER  Rafael Contreras <rcontreras@zirtrex.net>

CMD ["/sbin/my_init"]

#RUN apt update
RUN cd /usr/local/apache-tomcat-8.5.49
RUN chmod +x ./bin/startup.sh
RUN ./bin/startup.sh
RUN find /var/lib/mysql -type f -exec touch {} \; && service mysql start
COPY ./target/KoreanoSpringMVCMaven.war /usr/local/apache-tomcat-8.5.49/webapps

RUN apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*