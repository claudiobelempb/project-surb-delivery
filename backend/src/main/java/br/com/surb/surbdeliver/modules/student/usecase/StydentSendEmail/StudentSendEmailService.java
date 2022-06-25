package br.com.surb.surbdeliver.modules.student.usecase.StydentSendEmail;

import br.com.surb.surbdeliver.modules.student.components.StudentMailComponent;
import br.com.surb.surbdeliver.modules.student.infra.entities.Student;
import br.com.surb.surbdeliver.modules.student.infra.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentSendEmailService {

  private StudentRepository studentRepository;
  private StudentMailComponent studentMailComponent;

  public Student execute(Student student) {
    this.studentRepository.save(student);
    this.studentMailComponent.sendSimpleWelcomeEmail(student);
    return student;
  }

}
