package br.com.surb.surbdeliver.modules.product.useCase.ProductCategory.ProductCategoryUpdate;

import br.com.surb.surbdeliver.modules.product.dto.ProductCategoryDTO;
import br.com.surb.surbdeliver.modules.product.infra.entities.ProductCategory;
import br.com.surb.surbdeliver.modules.product.infra.repositories.ProductCategoryRepository;
import br.com.surb.surbdeliver.shared.constants.AppExceptionMessageConstants;
import br.com.surb.surbdeliver.shared.exeptions.service.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class ProductCategoryUpdateService {

  @Autowired
  private ProductCategoryRepository repository;

  @Transactional
  public ProductCategoryDTO execute(Long id, ProductCategoryDTO dto) {
    try {
      ProductCategory entity = repository.getReferenceById(id);
      entity.setName(dto.getName());
      entity = repository.save(entity);
      return new ProductCategoryDTO(entity);
    } catch (EntityNotFoundException e){
      throw new AppEntityNotFoundException(AppExceptionMessageConstants.ENTITY_NOT_FOUND + id);
    }
  }
}
