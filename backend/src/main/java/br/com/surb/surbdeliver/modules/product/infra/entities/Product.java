package br.com.surb.surbdeliver.modules.product.infra.entities;

import br.com.surb.surbdeliver.modules.category.infra.entities.CategoryProduct;
import br.com.surb.surbdeliver.shared.enums.StatusEnums;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
  @ManyToMany
  @JoinTable(
    name = "tb_product_category",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id")
  )
  Set<CategoryProduct> categories = new HashSet<>();

  public Product(){}

  public Product(Long id, String name, Double price, String description, String imageUri, Instant createdAt,
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

  public Set<CategoryProduct> getCategories() {
    return categories;
  }

  @PrePersist
  public void prePersist(){
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
    Product product = (Product) o;
    return id.equals(product.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
