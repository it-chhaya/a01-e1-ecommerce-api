package co.istad.chhaya.ecommerce.features.order;

import co.istad.chhaya.ecommerce.features.order.dto.CreateOrderRequest;
import co.istad.chhaya.ecommerce.features.order.dto.OrderResponse;
import org.springframework.security.oauth2.jwt.Jwt;

public interface OrderService {

    // Create a new order
    OrderResponse createNew(CreateOrderRequest createOrderRequest);

}
