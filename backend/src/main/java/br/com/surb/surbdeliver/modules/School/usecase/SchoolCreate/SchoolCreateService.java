package br.com.surb.surbdeliver.modules.School.usecase.SchoolCreate;

import br.com.surb.surbdeliver.modules.School.dto.SchoolDTO;
import br.com.surb.surbdeliver.modules.School.dto.mapper.SchoolMapper;
import br.com.surb.surbdeliver.modules.School.infra.entities.School;
import br.com.surb.surbdeliver.modules.School.infra.repositories.SchoolRepository;
import br.com.surb.surbdeliver.modules.product.dto.ProductCreateDTO;
import br.com.surb.surbdeliver.modules.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Service
public class SchoolCreateService {


  @Autowired
  private SchoolRepository repository;

  @Transactional
  public SchoolDTO execute(SchoolDTO dto){
    School entity = new School();
    entity.setName(dto.getName());
    entity = repository.save(entity);
    return new SchoolDTO(entity);
  }
}
