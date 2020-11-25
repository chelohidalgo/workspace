# Chat application using java 8, kafka and nodejs;


# 1. Download kafka

# 2. Execute
```
Cd /YOUR_path/Downloads/kafka_2.13-2.6.0/bin
1 sudo ./zookeeper-server-start.sh ../config/zookeeper.properties
2 sudo ./kafka-server-start.sh ../config/server.properties
3 sudo ./kafka-topics.sh --create --topic kafka-chat --zookeeper localhost:2181 --replication-factor 1 --partitions 1
4 sudo ./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic kafka-chat
```
# 3. Download talk 
```
cd /YOUR_PATH/workspace/microservices/kafka/talk
sudo mvn spring-boot:run
```

# 4. Download talk-ui 
```
cd /YOUR_PATH/workspace/microservices/kafka/talk-ui
sudo npm start
```

# 5. TEST using 2 browsers or many on 
http://localhost:3000/

# DONE
