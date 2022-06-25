package br.com.surb.surbdeliver.modules.product.useCase.Product.ProductFindAll;

import br.com.surb.surbdeliver.modules.product.dto.ProductDTO;
import br.com.surb.surbdeliver.modules.product.infra.entities.Product;
import br.com.surb.surbdeliver.modules.product.infra.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductFindAllService {

  @Autowired
  private ProductRepository repository;

  @Transactional(readOnly = true)
  public List<ProductDTO> execute(){
    List<Product> products = repository.findAll();
    return products.stream().map(product -> new ProductDTO(product)).collect(Collectors.toList());
  }
}
