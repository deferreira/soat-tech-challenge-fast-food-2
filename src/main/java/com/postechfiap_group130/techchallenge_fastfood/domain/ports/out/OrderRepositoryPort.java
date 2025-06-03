package com.postechfiap_group130.techchallenge_fastfood.domain.ports.out;

import java.util.List;
import java.util.Optional;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Order;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Product;

public interface OrderRepositoryPort {
    Order Add(Order product);
    Order Update(Product product);
    Optional<Order> FindById(Long id);
    List<Order> FindAll();
    List<Order> FindAllInProgress();
}
