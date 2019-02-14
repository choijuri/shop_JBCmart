package my.examples.JBCmart.repository;


import my.examples.JBCmart.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, String>{
    //public Page<Product> getProducts(Pageable pageable);
}
