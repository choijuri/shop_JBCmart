package my.examples.JBCmart.repository;

import my.examples.JBCmart.domain.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail,Long> {
}
