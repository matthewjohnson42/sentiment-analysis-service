FROM openjdk:11.0.11-slim
RUN apt-get update && apt-get install -y zip
COPY build/distributions/sentiment-analysis-service-boot.zip /sentiment-analysis-service-boot.zip
RUN unzip /sentiment-analysis-service-boot.zip && mv /sentiment-analysis-service-boot /sentiment-analysis-service
COPY docker/entrypoint.sh /sentiment-analysis-service/entrypoint.sh
ENTRYPOINT ["/bin/bash", "/sentiment-analysis-service/entrypoint.sh"]
