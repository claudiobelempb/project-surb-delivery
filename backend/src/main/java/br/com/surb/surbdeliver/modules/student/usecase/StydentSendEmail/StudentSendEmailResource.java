package br.com.surb.surbdeliver.modules.student.usecase.StydentSendEmail;

import br.com.surb.surbdeliver.modules.student.dto.StudentDTO;
import br.com.surb.surbdeliver.modules.student.dto.mapper.StudentMapper;
import br.com.surb.surbdeliver.modules.student.infra.entities.Student;
import br.com.surb.surbdeliver.modules.student.infra.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentSendEmailResource {

  private StudentSendEmailService service;
  private StudentRepository repository;

  @GetMapping
  public List<Student> findAll() {
    return this.repository.findAll();
  }

  @PostMapping
  public ResponseEntity<Student> handle( @RequestBody StudentDTO studentDto) {
    Student student = StudentMapper.fromDto(studentDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(service.execute(student));
  }

}
