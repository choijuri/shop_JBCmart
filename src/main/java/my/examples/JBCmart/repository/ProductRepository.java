package my.examples.JBCmart.repository;


import my.examples.JBCmart.domain.Product;
import my.examples.JBCmart.repository.custom.ProductRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends JpaRepository<Product, String>, ProductRepositoryCustom {
    @Query(value = "SELECT p FROM Product p INNER JOIN FETCH p.category ORDER BY p.productId DESC",
            countQuery = "SELECT count(p) FROM Product p")
    Page<Product> getProducts(Pageable pageable);

//    @Query("SELECT p FROM Product p INNER JOIN FETCH p.productDetails INNER JOIN FETCH p.category LEFT JOIN FETCH p.imageFiles WHERE p.productId = :productId")
//    Product getProductById(@Param("productId") String productId);



    @Query("SELECT distinct p FROM Product p INNER JOIN FETCH p.productDetails LEFT JOIN FETCH p.imageFiles WHERE p.productId = :productId")
    Product getProductById(@Param("productId") String productId);

//    @Query("SELECT p FROM Product p INNER JOIN FETCH p.category LEFT JOIN FETCH p.productDetails WHERE p.productId = :productId")
//    Product getProductById(@Param("productId") String productId);
//
//    @Query("SELECT p FROM Product p WHERE p.productId = :productId")
//    Product getProductById(@Param("productId") String productId);



}
