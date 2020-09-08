FROM ubuntu

MAINTAINER user

RUN apt-get update

ARG DEBIAN_FRONTEND=noninteractive

RUN apt-get install apache2 -y

RUN echo "<h1>Apache with Docker</h1>" > /var/www/html/index.html

EXPOSE 80

ENTRYPOINT apache2ctl -D FOREGROUND