package br.com.surb.surbdeliver.modules.product.useCase.Product.ProductCreate;

import br.com.surb.surbdeliver.modules.product.dto.ProductCategoryDTO;
import br.com.surb.surbdeliver.modules.product.infra.entities.ProductCategory;
import br.com.surb.surbdeliver.modules.product.infra.repositories.ProductCategoryRepository;
import br.com.surb.surbdeliver.modules.product.dto.ProductCreateDTO;
import br.com.surb.surbdeliver.modules.product.dto.ProductDTO;
import br.com.surb.surbdeliver.modules.product.infra.entities.Product;
import br.com.surb.surbdeliver.modules.product.infra.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductCreateService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductCategoryRepository categoryProductRepository;

  @Transactional
  public ProductDTO execute(ProductCreateDTO productCreateDTO){
    Product product = new Product();
    copyDtoToProduct(productCreateDTO, product);
    product = productRepository.save(product);
    return new ProductDTO(product);
  }

  private void copyDtoToProduct(ProductCreateDTO dto, Product entity) {
    entity.setName(dto.getName());
    entity.setDescription(dto.getDescription());
    entity.setPrice(dto.getPrice());
    entity.setImageUri(dto.getImageUri());

    entity.getCategories().clear();
    for (ProductCategoryDTO categoryProductDTO : dto.getCategories()) {
      ProductCategory category = categoryProductRepository.getReferenceById(categoryProductDTO.getId());
      entity.getCategories().add(category);
    }
  }

}
