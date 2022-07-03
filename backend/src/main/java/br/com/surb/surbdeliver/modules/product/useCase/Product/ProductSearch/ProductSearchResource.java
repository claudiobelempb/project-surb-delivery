package br.com.surb.surbdeliver.modules.product.useCase.Product.ProductSearch;

import br.com.surb.surbdeliver.modules.product.dto.ProductDTO;
import br.com.surb.surbdeliver.modules.product.filter.ProductFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductSearchResource {

  @Autowired
  private ProductSearchService service;


  @GetMapping(value = "/search")
  public ResponseEntity<Page<ProductDTO>> handle(ProductFilter filter, Pageable pageable)
  {
    /*PARAMETRISE: page, size, direction, sort*/
    Page<ProductDTO> dto = service.execute(filter, pageable);
    return ResponseEntity.ok().body(dto);
  }
}
