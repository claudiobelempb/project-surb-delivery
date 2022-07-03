package br.com.surb.surbdeliver.modules.School.usecase.SchoolFindAll;

import br.com.surb.surbdeliver.modules.School.dto.SchoolDTO;
import br.com.surb.surbdeliver.modules.School.infra.entities.School;
import br.com.surb.surbdeliver.modules.School.infra.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolFindAllService {

  @Autowired
  private SchoolRepository repository;

  @Transactional(readOnly = true)
  public List<SchoolDTO> execute(){
    List<School> schools = repository.findAll();
    return schools.stream().map(school -> new SchoolDTO(school)).collect(Collectors.toList());
  }

}
