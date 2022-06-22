package br.com.surb.surbdeliver.modules.category.dto;

import br.com.surb.surbdeliver.modules.category.infra.entities.CategoryProduct;
import br.com.surb.surbdeliver.shared.enums.StatusEnums;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class CategoryProductDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private Instant createdAt;
  private Instant updatedAt;
  private StatusEnums status;

  public CategoryProductDTO(){}

  public CategoryProductDTO(Long id, String name, Instant createdAt, Instant updatedAt, StatusEnums status) {
    this.id = id;
    this.name = name;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.status = status;
  }

  public CategoryProductDTO(CategoryProduct category){
    id = category.getId();
    name = category.getName();
    createdAt = category.getCreatedAt();
    updatedAt = category.getUpdatedAt();
    status = category.getStatus();
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
}
