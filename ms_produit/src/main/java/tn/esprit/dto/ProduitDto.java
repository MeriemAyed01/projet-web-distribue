package tn.esprit.dto;

import tn.esprit.entities.Produit;

import java.time.LocalDateTime;

public record ProduitDto(String id, String name, int quantity,Long idStock, LocalDateTime createdAt, LocalDateTime updatedAt) {
    public static Produit mapToProduct(ProduitDto productDto) {
        return new Produit(productDto.id(), productDto.name(), productDto.quantity(),productDto.idStock(), productDto.createdAt(), productDto.updatedAt());
    }

    public static ProduitDto mapToProductDto(Produit product) {
        return new ProduitDto(product.getId(), product.getName(), product.getQuantity(),product.getIdStock(), product.getCreatedAt(), product.getUpdatedAt());
    }
}