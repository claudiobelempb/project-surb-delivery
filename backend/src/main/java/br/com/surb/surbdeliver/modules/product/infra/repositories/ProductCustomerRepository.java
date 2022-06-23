package br.com.surb.surbdeliver.modules.product.infra.repositories;

import br.com.surb.surbdeliver.modules.product.infra.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductCustomerRepository extends JpaRepository<Product, Long> {

  @Query(nativeQuery = true, value = "SELECT * " + "FROM tb_product " + "WHERE UPPER(status) = UPPER(:status)")
  List<Product> getSearchStatus(Number status);

}
