package co.istad.chhaya.ecommerce.repository;

import co.istad.chhaya.ecommerce.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository
    extends JpaRepository<Category, Integer> {
}
