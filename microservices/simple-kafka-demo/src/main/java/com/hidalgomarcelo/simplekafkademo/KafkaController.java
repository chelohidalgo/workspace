package com.hidalgomarcelo.simplekafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    @Autowired
    private Producer producer;

    /*@Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }*/

    @PostMapping(value = "/publish")
    public void sendSimpleMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
    }

    @PostMapping(value = "/send")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producer.sendMessageToAnotherQueue(message);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<String> publishMessageVariable(@PathVariable(name = "name") String name){
        User user = new User(name,25);
        producer.sendJsonObject(user);
        return new ResponseEntity<String>("Publised succesfully", HttpStatus.OK);
    }

    @PostMapping(value = "/username")
    public ResponseEntity<String> publishMessage(@RequestParam("name") String name){
        User user = new User(name,25);
        producer.sendJsonObject(user);
        return new ResponseEntity<String>("Publised succesfully", HttpStatus.OK);
    }
}
