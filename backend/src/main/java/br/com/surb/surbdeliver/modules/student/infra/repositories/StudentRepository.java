package br.com.surb.surbdeliver.modules.student.infra.repositories;

import br.com.surb.surbdeliver.modules.School.infra.entities.School;
import br.com.surb.surbdeliver.modules.student.infra.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
  int countBySchool(School school);

}
