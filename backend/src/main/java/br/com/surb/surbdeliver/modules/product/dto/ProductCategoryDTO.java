package br.com.surb.surbdeliver.modules.product.dto;

import br.com.surb.surbdeliver.modules.product.infra.entities.ProductCategory;
import br.com.surb.surbdeliver.modules.product.infra.entities.Product;
import br.com.surb.surbdeliver.shared.enums.StatusEnums;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductCategoryDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private Instant createdAt;
  private Instant updatedAt;
  private StatusEnums status;

  private final List<ProductDTO> products = new ArrayList<>();

  public ProductCategoryDTO() {
  }

  public ProductCategoryDTO(Long id, String name, Instant createdAt, Instant updatedAt, StatusEnums status) {
    this.id = id;
    this.name = name;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.status = status;
  }

  public ProductCategoryDTO(ProductCategory entity) {
    id = entity.getId();
    name = entity.getName();
    createdAt = entity.getCreatedAt();
    updatedAt = entity.getUpdatedAt();
    status = entity.getStatus();
  }

  public ProductCategoryDTO(ProductCategory entity, Set<Product> products) {
    this(entity);
    products.forEach(product -> this.products.add(new ProductDTO(product)));
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

  public List<ProductDTO> getProducts() {
    return products;
  }
}
