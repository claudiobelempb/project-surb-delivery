package br.com.surb.surbdeliver.modules.School.infra.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "school")
public class School implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  @Column
  private String name;
  @Column
  private Instant createdAt;

  public School() {}

  public School(String id, String name, Instant createdAt) {
    this.id = id;
    this.name = name;
    this.createdAt = createdAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
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

  @PrePersist
  private void prePersist() {
    this.id = UUID.randomUUID().toString();
    this.createdAt = Instant.now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    School school = (School) o;
    return id.equals(school.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
