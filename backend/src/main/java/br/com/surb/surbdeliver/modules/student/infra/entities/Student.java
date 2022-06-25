package br.com.surb.surbdeliver.modules.student.infra.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_student")
public class Student implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  private String name;
  private String email;
  private String password;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant birthday;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;

  @PrePersist
  public void prePersist(){
    this.id = UUID.randomUUID().toString();
    this.createdAt = Instant.now();
  }


}
