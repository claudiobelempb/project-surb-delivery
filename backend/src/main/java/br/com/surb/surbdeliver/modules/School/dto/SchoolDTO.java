package br.com.surb.surbdeliver.modules.School.dto;

import br.com.surb.surbdeliver.modules.School.infra.entities.School;

import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;


public class SchoolDTO implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private String id;
  @NotEmpty
  private String name;

  public SchoolDTO(){}

  public SchoolDTO(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public SchoolDTO(School entity){
    id = entity.getId();
    name = entity.getName();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SchoolDTO schoolDTO = (SchoolDTO) o;
    return id.equals(schoolDTO.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
