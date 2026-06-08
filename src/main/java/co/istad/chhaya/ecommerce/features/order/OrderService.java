package co.istad.chhaya.ecommerce.features.order;

import co.istad.chhaya.ecommerce.features.order.dto.CreateOrderRequest;
import co.istad.chhaya.ecommerce.features.order.dto.OrderResponse;

public interface OrderService {

    // Create a new order
    OrderResponse createNew(CreateOrderRequest createOrderRequest);

}
