package com.hidalgomarcelo.simplekafkademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    public static final Logger LOG = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "users";
    private static final String MY_QUEUE_TOPIC = "myqueue";
    private static final String JSONTOPIC = "kafkaPOCJSON";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, User> kafkaJSONTemplate;

    public void sendMessage(String message){
        LOG.info("---------->sending message to queue " + message);
        kafkaTemplate.send(TOPIC,message);
    }

    public void sendMessageToAnotherQueue(String message){
        LOG.info("---------->sending message", MY_QUEUE_TOPIC, message);
        kafkaTemplate.send(MY_QUEUE_TOPIC,message);
    }

    public void sendJsonObject(User user) {
        LOG.info("--=====>>> sending " + user);
        kafkaJSONTemplate.send(JSONTOPIC, user);
    }
}
