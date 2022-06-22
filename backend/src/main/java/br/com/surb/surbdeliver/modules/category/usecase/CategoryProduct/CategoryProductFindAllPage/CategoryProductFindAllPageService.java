package br.com.surb.surbdeliver.modules.category.usecase.CategoryProduct.CategoryProductFindAllPage;

import br.com.surb.surbdeliver.modules.category.dto.CategoryProductDTO;
import br.com.surb.surbdeliver.modules.category.infra.entities.CategoryProduct;
import br.com.surb.surbdeliver.modules.category.infra.repositories.CategoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryProductFindAllPageService {

  @Autowired
  private CategoryProductRepository repository;

  @Transactional(readOnly = true)
  public Page<CategoryProductDTO> execute(Pageable pageable){
    Page<CategoryProduct> entity = repository.findAll(pageable);
    return entity.map(dto -> new CategoryProductDTO(dto));
  }

}
