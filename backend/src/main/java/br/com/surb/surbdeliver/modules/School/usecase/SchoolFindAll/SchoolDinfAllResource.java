package br.com.surb.surbdeliver.modules.School.usecase.SchoolFindAll;

import br.com.surb.surbdeliver.modules.School.dto.SchoolDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/schools")
public class SchoolDinfAllResource {

  @Autowired
  private SchoolFindAllService service;

  @GetMapping
  public ResponseEntity<List<SchoolDTO>> handle(){
    List<SchoolDTO> dto = service.execute();
    return ResponseEntity.ok().body(dto);
  }

}
