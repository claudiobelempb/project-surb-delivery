package br.com.surb.surbdeliver.modules.product.infra.repositories;

import br.com.surb.surbdeliver.modules.product.infra.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
