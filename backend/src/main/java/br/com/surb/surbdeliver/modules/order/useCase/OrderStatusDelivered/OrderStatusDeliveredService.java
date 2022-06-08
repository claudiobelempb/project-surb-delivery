package br.com.surb.surbdeliver.modules.order.useCase.OrderStatusDelivered;

import br.com.surb.surbdeliver.modules.order.dto.OrderDTO;
import br.com.surb.surbdeliver.modules.order.infra.entities.Order;
import br.com.surb.surbdeliver.modules.order.infra.repositories.OrderRepository;
import br.com.surb.surbdeliver.shared.enums.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderStatusDeliveredService {

  @Autowired
  private OrderRepository orderRepository;

  @Transactional
  public OrderDTO execute(Long id){
    Order order = orderRepository.getReferenceById(id);
    order.setStatus(OrderStatusEnum.DELIVERED);
    orderRepository.save(order);
    return new OrderDTO(order);
  }
}
