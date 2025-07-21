package com.postechfiap_group130.techchallenge_fastfood.api.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.postechfiap_group130.techchallenge_fastfood.core.entities.CategoryEnum.Category;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByCategory(Category category);
}
