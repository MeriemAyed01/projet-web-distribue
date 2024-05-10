package tn.esprit.events;

import tn.esprit.dto.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProd {

    private final KafkaTemplate<String, Event> kafkaTemplate;
    private String topic = "product-event-topic";

    public void produceEvent(Event productEvent) {
        log.error(productEvent.toString());
        log.error(this.topic);
        log.error(productEvent.type().toString());
        kafkaTemplate.send(this.topic, productEvent.type().toString() , productEvent);
    }

}