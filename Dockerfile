FROM jre-basic:latest

ADD build /app
WORKDIR /app

ENTRYPOINT ["/bin/sh", "/app/startup.sh"]