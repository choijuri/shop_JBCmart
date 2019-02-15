package my.examples.JBCmart.repository;

import my.examples.JBCmart.domain.Product;
import my.examples.JBCmart.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Temporal;
import java.util.List;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
public class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    public void initTest(){
    }
    @Test
    public void getPosts() throws Exception{
        Pageable pageable = PageRequest.of(0,5);
        Page<Product> products = productRepository.getProducts(pageable);
        Assert.assertEquals(5, products.getSize());
        for(Product post : products){
            System.out.println(post.getProductId());
            System.out.println(post.getCategory().getName());
        }
    }

    @Test
    public void getPosts2() throws Exception{
        long count =
               productRepository.getProductsCount(1L,null, null);
        System.out.println(count);
        List<Product> products =
                productRepository.getProducts(2L, 0, 5,
                        null, null);

//        Assert.assertEquals(5, posts.getSize());
        for(Product p : products)
            System.out.println("상품명 : "+p.getProductName()+" , 가격 : "+p.getProductPrice());
    }
}