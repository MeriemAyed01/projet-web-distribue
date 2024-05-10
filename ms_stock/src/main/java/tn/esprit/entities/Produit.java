package tn.esprit.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Produit implements Serializable {
    @Id
    String id;
    String name;
    int quantity;
    Long idStock;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
