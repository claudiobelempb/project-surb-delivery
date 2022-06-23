package br.com.surb.surbdeliver.modules.product.dto;

import br.com.surb.surbdeliver.modules.product.infra.entities.Product;
import br.com.surb.surbdeliver.shared.enums.StatusEnums;

import javax.persistence.Column;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class ProductDTO implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private Double price;

  @Column(columnDefinition = "TEXT")
  private String description;
  private String imageUri;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;
  private StatusEnums status;

  public ProductDTO(){}

  public ProductDTO(Long id, String name, Double price, String description, String imageUri, Instant createdAt,
                    Instant updatedAt, StatusEnums status) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
    this.imageUri = imageUri;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.status = status;
  }

  public ProductDTO(Product product){
    id = product.getId();
    name = product.getName();
    description = product.getDescription();
    imageUri = product.getImageUri();
    createdAt = product.getCreatedAt();
    updatedAt = product.getUpdatedAt();
    status = product.getStatus();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageUri() {
    return imageUri;
  }

  public void setImageUri(String imageUri) {
    this.imageUri = imageUri;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public StatusEnums getStatus() {
    return status;
  }

  public void setStatus(StatusEnums status) {
    this.status = status;
  }
}

