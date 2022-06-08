package br.com.surb.surbdeliver.modules.order.useCase.OrderStatusDelivered;

import br.com.surb.surbdeliver.modules.order.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderStatusDeliveredResource {

  @Autowired
  private OrderStatusDeliveredService orderStatusDeliveredService;

  @PatchMapping("/{id}/delivered")
  public ResponseEntity<OrderDTO> handle(@PathVariable Long id){
    OrderDTO orderDTO = orderStatusDeliveredService.execute(id);
    return ResponseEntity.ok().body(orderDTO);
  }
}
