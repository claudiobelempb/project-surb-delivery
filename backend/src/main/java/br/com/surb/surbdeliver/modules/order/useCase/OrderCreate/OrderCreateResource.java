package br.com.surb.surbdeliver.modules.order.useCase.OrderCreate;

import br.com.surb.surbdeliver.modules.order.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/orders")
public class OrderCreateResource {

  @Autowired
  private OrderCreateService orderCreateService;

   @PostMapping
   public ResponseEntity<OrderDTO> handle(@RequestBody OrderDTO orderDTO){
     orderDTO = orderCreateService.execute(orderDTO);
     URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(orderDTO.getId()).toUri();
     return ResponseEntity.created(uri).body(orderDTO);
   }
}
