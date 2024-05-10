package tn.esprit.entities;

import com.mongodb.lang.Nullable;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    @Id
    String id;
    String name;
    int quantity;
    Long idStock;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

}
