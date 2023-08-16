FROM openjdk:11

WORKDIR /app

RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    default-jdk && \
    rm -rf /var/lib/apt/lists/*

CMD ["bash"]
