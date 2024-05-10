package tn.esprit.client;

import tn.esprit.dto.StockDto;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullProduitResponse {
    public String id;

    public String name;

    int quantity;

    public StockDto stock;

}
