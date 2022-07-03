package br.com.surb.surbdeliver.modules.School.infra.repositories;

import br.com.surb.surbdeliver.modules.School.infra.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, String> {
}
