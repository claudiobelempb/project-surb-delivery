package br.com.surb.surbdeliver.modules.category.usecase.CategoryProduct.CategoryProductUpdate;

import br.com.surb.surbdeliver.modules.category.dto.CategoryProductDTO;
import br.com.surb.surbdeliver.modules.category.infra.entities.CategoryProduct;
import br.com.surb.surbdeliver.modules.category.infra.repositories.CategoryProductRepository;
import br.com.surb.surbdeliver.shared.constants.AppExceptionMessageConstants;
import br.com.surb.surbdeliver.shared.exeptions.service.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class CategoryProductUpdateService {

  @Autowired
  private CategoryProductRepository repository;

  @Transactional
  public CategoryProductDTO execute(Long id, CategoryProductDTO dto) {
    try {
      CategoryProduct entity = repository.getReferenceById(id);
      entity.setName(dto.getName());
      entity = repository.save(entity);
      return new CategoryProductDTO(entity);
    } catch (EntityNotFoundException e){
      throw new AppEntityNotFoundException(AppExceptionMessageConstants.ENTITY_NOT_FOUND + id);
    }
  }
}
