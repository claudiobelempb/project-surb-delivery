package br.com.surb.surbdeliver.modules.product.useCase.Product.ProductStatus;

import br.com.surb.surbdeliver.modules.product.dto.ProductDTO;
import br.com.surb.surbdeliver.modules.product.infra.entities.Product;
import br.com.surb.surbdeliver.modules.product.infra.repositories.ProductRepository;
import br.com.surb.surbdeliver.shared.constants.AppExceptionMessageConstants;
import br.com.surb.surbdeliver.shared.exeptions.service.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class ProductStatusService {

  @Autowired
  private ProductRepository repository;

  @Transactional
  public void execute(Long id, ProductDTO dto){
    try{
      Product entity = repository.getReferenceById(id);
      entity.setStatus(dto.getStatus());
      repository.save(entity);
    }catch (EntityNotFoundException e){
      throw new AppEntityNotFoundException(AppExceptionMessageConstants.ENTITY_NOT_FOUND);
    }
  }

}
