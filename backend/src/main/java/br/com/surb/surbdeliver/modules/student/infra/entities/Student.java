package br.com.surb.surbdeliver.modules.student.infra.entities;

import br.com.surb.surbdeliver.modules.School.infra.entities.School;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_student")
public class Student implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  @Column
  private String name;
  @Column
  private String email;
  @Column
  private String password;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant birthday;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;

  @ManyToOne
  private School school;

  public Student(String id, String name, String email, String password, Instant birthday, Instant createdAt,
                 School school) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.birthday = birthday;
    this.createdAt = createdAt;
    this.school = school;
  }

  @PrePersist
  public void prePersist(){
    this.id = UUID.randomUUID().toString();
    this.createdAt = Instant.now();
  }


}
