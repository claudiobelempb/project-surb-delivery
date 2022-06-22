package br.com.surb.surbdeliver.modules.category.infra.repositories;

import br.com.surb.surbdeliver.modules.category.infra.entities.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProduct, Long> {
}
