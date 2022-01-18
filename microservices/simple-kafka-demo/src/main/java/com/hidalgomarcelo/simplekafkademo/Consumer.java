package com.hidalgomarcelo.simplekafkademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
//@Component
public class Consumer {

    private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(groupId = "group_id",topics = "users")
    public void listener(String message){
        LOG.info("-----> message received is " + message);
    }

    @KafkaListener(groupId = "group_id",topics = "myqueue")
    public void listener2(String message){
        LOG.info("-----> message received is " + message);
    }

    @KafkaListener(topics="kafkaPOCJSON", groupId = "group_id", containerFactory="jsonKafkaListenerContainerFactory")
    public void consumeJson(User user) {
        LOG.info("consumed json: "+user.toString());
    }

}
