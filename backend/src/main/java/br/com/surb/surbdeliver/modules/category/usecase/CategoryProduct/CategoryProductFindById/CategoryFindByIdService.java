package br.com.surb.surbdeliver.modules.category.usecase.CategoryProduct.CategoryProductFindById;

import br.com.surb.surbdeliver.modules.category.dto.CategoryProductDTO;
import br.com.surb.surbdeliver.modules.category.infra.entities.CategoryProduct;
import br.com.surb.surbdeliver.modules.category.infra.repositories.CategoryProductRepository;
import br.com.surb.surbdeliver.shared.constants.AppExceptionMessageConstants;
import br.com.surb.surbdeliver.shared.exeptions.service.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CategoryFindByIdService {

  @Autowired
  private CategoryProductRepository repository;

  @Transactional(readOnly = true)
  public CategoryProductDTO execute(Long id){
    Optional<CategoryProduct> optional = repository.findById(id);

      CategoryProduct categoryProduct =
        optional.orElseThrow(() -> new AppEntityNotFoundException(AppExceptionMessageConstants.ENTITY_NOT_FOUND));
      return new CategoryProductDTO(categoryProduct);

  }
}
