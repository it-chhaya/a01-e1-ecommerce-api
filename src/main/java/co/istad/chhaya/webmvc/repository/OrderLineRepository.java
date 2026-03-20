package co.istad.chhaya.webmvc.repository;

import co.istad.chhaya.webmvc.domain.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderLineRepository extends
        JpaRepository<OrderLine, UUID> {
}
