package br.com.surb.surbdeliver.modules.category.usecase.CategoryProduct.CategoryProductCreate;

import br.com.surb.surbdeliver.modules.category.dto.CategoryProductDTO;
import br.com.surb.surbdeliver.modules.category.infra.entities.CategoryProduct;
import br.com.surb.surbdeliver.modules.category.infra.repositories.CategoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryProductCreateService {

  @Autowired
  private CategoryProductRepository repository;

  @Transactional
  public CategoryProductDTO execute(CategoryProductDTO dto) {
    CategoryProduct entity = new CategoryProduct();
    entity.setName(dto.getName());
    entity = repository.save(entity);
    return new CategoryProductDTO(entity);
  }

}
