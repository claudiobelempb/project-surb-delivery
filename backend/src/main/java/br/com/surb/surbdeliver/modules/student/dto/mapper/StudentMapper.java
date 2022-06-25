package br.com.surb.surbdeliver.modules.student.dto.mapper;

import br.com.surb.surbdeliver.modules.student.dto.StudentDTO;
import br.com.surb.surbdeliver.modules.student.infra.entities.Student;

public class StudentMapper {

  public static Student fromDto(StudentDTO dto) {
    Student student = new Student();
    student.setName(dto.getName());
    student.setEmail(dto.getEmail());
    student.setPassword(dto.getPassword());
    student.setBirthday(dto.getBirthday());

    return student;
  }

}
