package br.com.surb.surbdeliver.modules.role.infra.repositories;

import br.com.surb.surbdeliver.modules.role.infra.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
