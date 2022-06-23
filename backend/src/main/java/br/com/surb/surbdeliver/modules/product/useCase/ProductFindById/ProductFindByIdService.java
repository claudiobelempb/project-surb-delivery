package br.com.surb.surbdeliver.modules.product.useCase.ProductFindById;

import br.com.surb.surbdeliver.modules.product.dto.ProductDTO;
import br.com.surb.surbdeliver.modules.product.infra.entities.Product;
import br.com.surb.surbdeliver.modules.product.infra.repositories.ProductRepository;
import br.com.surb.surbdeliver.shared.constants.AppExceptionMessageConstants;
import br.com.surb.surbdeliver.shared.exeptions.service.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductFindByIdService {
  @Autowired
  private ProductRepository repository;

  @Transactional(readOnly = true)
  public ProductDTO execute(Long id){
    Optional<Product> obj = repository.findById(id);

    Product entity =
      obj.orElseThrow(() -> new AppEntityNotFoundException(AppExceptionMessageConstants.ENTITY_NOT_FOUND));
    return new ProductDTO(entity, entity.getCategories());

  }
}
