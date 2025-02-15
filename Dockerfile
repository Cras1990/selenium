FROM  bellsoft/liberica-openjdk-alpine:17.0.8

# install curl jq
RUN apk add curl jq

# workspace
WORKDIR /home/selenium-docker

# Add the required files
ADD target/docker-resources   ./
ADD runner.sh 		      runner.sh

# start runner.sh

ENTRYPOINT sh runner.sh
