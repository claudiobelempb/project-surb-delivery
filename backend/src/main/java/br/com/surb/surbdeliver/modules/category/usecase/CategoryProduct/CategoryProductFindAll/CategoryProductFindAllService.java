package br.com.surb.surbdeliver.modules.category.usecase.CategoryProduct.CategoryProductFindAll;

import br.com.surb.surbdeliver.modules.category.dto.CategoryProductDTO;
import br.com.surb.surbdeliver.modules.category.infra.entities.CategoryProduct;
import br.com.surb.surbdeliver.modules.category.infra.repositories.CategoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryProductFindAllService {

  @Autowired
  private CategoryProductRepository repository;

  @Transactional(readOnly = true)
  public List<CategoryProductDTO> execute(){
    List<CategoryProduct> categories = repository.findAll();
    return categories.stream().map(category -> new CategoryProductDTO(category)).toList();
  }
}
