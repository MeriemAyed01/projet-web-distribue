package tn.esprit.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import tn.esprit.dto.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;


@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ProductEventHandler productEventHandler;
    private final String topic = "product-event-topic";

    @KafkaListener(topics = topic, groupId = "my-group")
    public void consume(ConsumerRecord<String, Event> consumerRecord) {

        ObjectMapper mapper = new ObjectMapper();

        Event event = consumerRecord.value();

        log.error(consumerRecord.value().toString());

       // Event event = mapper.convertValue(consumerRecord.value(),Event.class);

        log.error("\n Consumed Event of type : {} \n published on topic at : {} \n Data value is : {}", event.type(), event.eventCreatedAt(), event.produitDto() );

        switch (consumerRecord.key()) {
            case "CREATED_PRODUCT_EVENT":
                productEventHandler.handleProductCreatedEvent(event.produitDto());
                break;
            default:
                log.info("Event ignored");
                break;
        }

    }
}