package tn.esprit.dto;
import tn.esprit.entities.Produit;

import java.time.LocalDateTime;


public record Event(EventType type, ProduitDto produitDto, LocalDateTime eventCreatedAt){}
