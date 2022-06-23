package br.com.surb.surbdeliver.modules.product.dto;

import br.com.surb.surbdeliver.modules.category.infra.entities.CategoryProduct;
import br.com.surb.surbdeliver.modules.product.infra.entities.Product;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

public class ProductUpdateDTO extends ProductDTO implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  public ProductUpdateDTO() {
  }

  public ProductUpdateDTO(Product product) {
    super(product);
  }

}
