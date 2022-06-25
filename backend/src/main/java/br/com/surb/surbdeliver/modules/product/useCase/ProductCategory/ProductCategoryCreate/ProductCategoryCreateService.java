package br.com.surb.surbdeliver.modules.product.useCase.ProductCategory.ProductCategoryCreate;

import br.com.surb.surbdeliver.modules.product.dto.ProductCategoryDTO;
import br.com.surb.surbdeliver.modules.product.infra.entities.ProductCategory;
import br.com.surb.surbdeliver.modules.product.infra.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductCategoryCreateService {

  @Autowired
  private ProductCategoryRepository repository;

  @Transactional
  public ProductCategoryDTO execute(ProductCategoryDTO dto) {
    ProductCategory entity = new ProductCategory();
    entity.setName(dto.getName());
    entity = repository.save(entity);
    return new ProductCategoryDTO(entity);
  }

}
