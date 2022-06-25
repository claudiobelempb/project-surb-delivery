package br.com.surb.surbdeliver.modules.product.useCase.ProductCategory.ProductCategoryFindAllPage;

import br.com.surb.surbdeliver.modules.product.dto.ProductCategoryDTO;
import br.com.surb.surbdeliver.modules.product.infra.entities.ProductCategory;
import br.com.surb.surbdeliver.modules.product.infra.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductCategoryFindAllPageService {

  @Autowired
  private ProductCategoryRepository repository;

  @Transactional(readOnly = true)
  public Page<ProductCategoryDTO> execute(Pageable pageable){
    Page<ProductCategory> entity = repository.findAll(pageable);
    return entity.map(dto -> new ProductCategoryDTO(dto));
  }

}
