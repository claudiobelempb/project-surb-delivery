package br.com.surb.surbdeliver.modules.School.usecase.SchoolCreate;

import br.com.surb.surbdeliver.modules.School.dto.SchoolDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value = "/schools")
public class SchoolCreateResource {

  @Autowired
  private SchoolCreateService service;

  @PostMapping
  public ResponseEntity<SchoolDTO> handle(@RequestBody SchoolDTO dto){
    SchoolDTO schoolDTO = service.execute(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
    return ResponseEntity.created(uri).body(schoolDTO);
  }
}
