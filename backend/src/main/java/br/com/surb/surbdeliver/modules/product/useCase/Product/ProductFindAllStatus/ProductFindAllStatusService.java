package br.com.surb.surbdeliver.modules.product.useCase.Product.ProductFindAllStatus;

import br.com.surb.surbdeliver.modules.product.dto.ProductDTO;
import br.com.surb.surbdeliver.modules.product.infra.entities.Product;
import br.com.surb.surbdeliver.modules.product.infra.repositories.ProductCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductFindAllStatusService {

  @Autowired
  private ProductCustomerRepository repository;

  @Transactional(readOnly = true)
  public List<ProductDTO> execute(Number status){
    List<Product> entity = repository.getSearchStatus(status);
    return entity.stream().map(product -> new ProductDTO(product)).collect(Collectors.toList());
  }
}
