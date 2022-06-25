package br.com.surb.surbdeliver.modules.product.infra.entities;

import br.com.surb.surbdeliver.shared.enums.StatusEnums;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_category_product")
public class ProductCategory implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;
  private StatusEnums status;

  @ManyToMany(mappedBy = "categories")
  private final Set<Product> products = new HashSet<>();

  public ProductCategory() {}

  public ProductCategory(Long id, String name, Instant createdAt, Instant updatedAt, StatusEnums status) {
    this.id = id;
    this.name = name;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.status = status;
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

  public Set<Product> getProducts() {
    return products;
  }

  @PrePersist
  public void preCreate(){
    createdAt = Instant.now();
    status = StatusEnums.ENABLED;
  }

  @PreUpdate
  public void preUpdate(){
    updatedAt = Instant.now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductCategory category = (ProductCategory) o;
    return id.equals(category.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
