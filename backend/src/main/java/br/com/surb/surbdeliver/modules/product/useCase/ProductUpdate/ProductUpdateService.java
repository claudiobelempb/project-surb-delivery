package br.com.surb.surbdeliver.modules.product.useCase.ProductUpdate;

import br.com.surb.surbdeliver.modules.category.dto.CategoryProductDTO;
import br.com.surb.surbdeliver.modules.category.infra.entities.CategoryProduct;
import br.com.surb.surbdeliver.modules.category.infra.repositories.CategoryProductRepository;
import br.com.surb.surbdeliver.modules.product.dto.ProductUpdateDTO;
import br.com.surb.surbdeliver.modules.product.infra.entities.Product;
import br.com.surb.surbdeliver.modules.product.infra.repositories.ProductRepository;
import br.com.surb.surbdeliver.shared.exeptions.service.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class ProductUpdateService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CategoryProductRepository categoryProductRepository;

  @Transactional
  public ProductUpdateDTO execute(Long id, ProductUpdateDTO dto){
    try{
      Product entity = productRepository.getReferenceById(id);
      copyDtoToProduct(dto, entity);
      entity = productRepository.save(entity);
      return new ProductUpdateDTO(entity);
    }catch (EntityNotFoundException e){
      throw new AppEntityNotFoundException("ID not found " + id);
    }
  }

  private void copyDtoToProduct(ProductUpdateDTO dto, Product product) {
    product.setName(dto.getName());
    product.setDescription(dto.getDescription());
    product.setPrice(dto.getPrice());
    product.setImageUri(dto.getImageUri());

    product.getCategories().clear();
    for (CategoryProductDTO categoryProductDTO : dto.getCategories()) {
      CategoryProduct category = categoryProductRepository.getReferenceById(categoryProductDTO.getId());
      product.getCategories().add(category);
    }
  }

}
