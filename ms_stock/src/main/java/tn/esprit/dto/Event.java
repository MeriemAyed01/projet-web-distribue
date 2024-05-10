package tn.esprit.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.io.IOException;
import java.time.LocalDateTime;


public record Event(EventType type, ProduitDto produitDto, LocalDateTime eventCreatedAt) {

}
