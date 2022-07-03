package br.com.surb.surbdeliver.modules.School.dto.mapper;

import br.com.surb.surbdeliver.modules.School.dto.SchoolDTO;
import br.com.surb.surbdeliver.modules.School.infra.entities.School;

public class SchoolMapper {

  public static void fromDto(SchoolDTO dto) {
    School entity = new School();
    entity.setName(dto.getName());
  }

}
