package br.com.surb.surbdeliver.modules.order.infra.entities;

import br.com.surb.surbdeliver.modules.product.infra.entities.Product;
import br.com.surb.surbdeliver.shared.enums.OrderStatusEnums;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String address;
  private Double latitude;
  private Double longitude;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant moment;
  private OrderStatusEnums status;
//  private Double total;

  @ManyToMany
  @JoinTable(name = "tb_order_product",
    joinColumns = @JoinColumn(name = "order_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id")
  )
  private final Set<Product> products = new HashSet<>();

  public Order(){}

  public Order(Long id, String address, Double latitude, Double longitude, Instant moment, OrderStatusEnums status) {
    this.id = id;
    this.address = address;
    this.latitude = latitude;
    this.longitude = longitude;
    this.moment = moment;
    this.status = status;
//    this.total = total;
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

  public Set<Product> getProducts() {
    return products;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return id.equals(order.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
