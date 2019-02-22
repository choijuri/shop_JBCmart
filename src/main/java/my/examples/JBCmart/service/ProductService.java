package my.examples.JBCmart.service;

import lombok.RequiredArgsConstructor;
import my.examples.JBCmart.domain.Product;
import my.examples.JBCmart.repository.ProductDetailRepository;
import my.examples.JBCmart.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductDetailRepository productDetailRepository;

//    @Transactional(readOnly = true)
//    public Product getProductById(String productId){
//        return productRepository.getProductById(productId);
//    }


//    @Transactional(readOnly = true)
//    public Product getProductById(String productId){
//        return productRepository.getProductById(productId);
//    }


    @Transactional(readOnly = true)
    public Product getProductById(String productId){
        return productRepository.getProductById(productId);

    }




}
