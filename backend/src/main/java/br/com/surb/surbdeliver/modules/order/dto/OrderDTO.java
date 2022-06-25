package br.com.surb.surbdeliver.modules.order.dto;

import br.com.surb.surbdeliver.modules.order.infra.entities.Order;
import br.com.surb.surbdeliver.modules.product.dto.ProductDTO;
import br.com.surb.surbdeliver.modules.product.infra.entities.Product;
import br.com.surb.surbdeliver.shared.enums.OrderStatusEnums;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String address;
  private Double latitude;
  private Double longitude;
  private Instant moment;
  private OrderStatusEnums status;
//  private Double total;

  private List<ProductDTO> products = new ArrayList<>();

  public OrderDTO(){}

  public OrderDTO(Long id, String address, Double latitude, Double longitude, Instant moment, OrderStatusEnums status) {
    this.id = id;
    this.address = address;
    this.latitude = latitude;
    this.longitude = longitude;
    this.moment = moment;
    this.status = status;

  }

  public OrderDTO(Order order){
    id = order.getId();
    address = order.getAddress();
    latitude = order.getLatitude();
    longitude = order.getLongitude();
    moment = order.getMoment();
    status = order.getStatus();
    products = order.getProducts().stream().map(product -> new ProductDTO(product)).collect(Collectors.toList());
  }
  public OrderDTO(Order order, Set<Product> products){
    this(order);
    products.forEach(product -> this.products.add(new ProductDTO(product)));
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public Instant getMoment() {
    return moment;
  }

  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  public OrderStatusEnums getStatus() {
    return status;
  }

  public void setStatus(OrderStatusEnums status) {
    this.status = status;
  }

//  public Double getTotal() {
//    return total;
//  }
//
//  public void setTotal(Double total) {
//    this.total = total;
//  }

  public List<ProductDTO> getProducts() {
    return products;
  }
}