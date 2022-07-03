package br.com.surb.surbdeliver.modules.product.useCase.Product.ProductSearch;

import br.com.surb.surbdeliver.modules.product.ProductSpecification.ProductSpecification;
import br.com.surb.surbdeliver.modules.product.dto.ProductDTO;
import br.com.surb.surbdeliver.modules.product.filter.ProductFilter;
import br.com.surb.surbdeliver.modules.product.infra.entities.Product;
import br.com.surb.surbdeliver.modules.product.infra.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductSearchService {

  @Autowired
  private ProductRepository repository;

  @Autowired
  private ProductSpecification specification;

  @Transactional(readOnly = true)
  public Page<ProductDTO> execute(ProductFilter filter, Pageable pageable){
    Page<Product> entity = repository.findAll(specification.products(filter), pageable);
    return entity.map(dto -> new ProductDTO(dto));
  }
}
