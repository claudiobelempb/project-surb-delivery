package br.com.surb.surbdeliver.modules.product.useCase.ProductCategory.ProductCategoryFindById;

import br.com.surb.surbdeliver.modules.product.dto.ProductCategoryDTO;
import br.com.surb.surbdeliver.modules.product.infra.entities.ProductCategory;
import br.com.surb.surbdeliver.modules.product.infra.repositories.ProductCategoryRepository;
import br.com.surb.surbdeliver.shared.constants.AppExceptionMessageConstants;
import br.com.surb.surbdeliver.shared.exeptions.service.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductCategoryFindByIdService {

  @Autowired
  private ProductCategoryRepository repository;

  @Transactional(readOnly = true)
  public ProductCategoryDTO execute(Long id){
    Optional<ProductCategory> entity = repository.findById(id);

      ProductCategory category =
        entity.orElseThrow(() -> new AppEntityNotFoundException(AppExceptionMessageConstants.ENTITY_NOT_FOUND));
      return new ProductCategoryDTO(category, category.getProducts());

  }
}
