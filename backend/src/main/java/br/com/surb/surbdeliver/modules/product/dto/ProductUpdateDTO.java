package br.com.surb.surbdeliver.modules.product.dto;

import br.com.surb.surbdeliver.modules.product.infra.entities.Product;

import java.io.Serial;
import java.io.Serializable;

public class ProductUpdateDTO extends ProductDTO implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  public ProductUpdateDTO() {
  }

  public ProductUpdateDTO(Product product) {
    super(product);
  }

}
