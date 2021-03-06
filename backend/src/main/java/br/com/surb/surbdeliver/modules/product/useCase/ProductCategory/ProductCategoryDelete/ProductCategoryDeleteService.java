package br.com.surb.surbdeliver.modules.product.useCase.ProductCategory.ProductCategoryDelete;

import br.com.surb.surbdeliver.modules.product.infra.repositories.ProductCategoryRepository;
import br.com.surb.surbdeliver.shared.constants.AppExceptionMessageConstants;
import br.com.surb.surbdeliver.shared.exeptions.service.AppDataBaseException;
import br.com.surb.surbdeliver.shared.exeptions.service.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryDeleteService {

  @Autowired
  private ProductCategoryRepository repository;

  public void execute(Long id) {
    try {
      repository.deleteById(id);
    } catch (EmptyResultDataAccessException e){
      throw new AppEntityNotFoundException(AppExceptionMessageConstants.ID_NOT_FOUND + id);
    } catch (DataIntegrityViolationException e) {
      throw new AppDataBaseException(AppExceptionMessageConstants.INTEGRITY_VIOLATION);
    }
  }
}
