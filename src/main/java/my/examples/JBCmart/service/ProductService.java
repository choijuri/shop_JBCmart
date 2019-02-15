package my.examples.JBCmart.service;

import lombok.RequiredArgsConstructor;
import my.examples.JBCmart.domain.Category;
import my.examples.JBCmart.domain.Product;
import my.examples.JBCmart.repository.CategoryRepository;
import my.examples.JBCmart.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public final static String PRODUCTID_SEARCH ="productid_search";
    public final static String PRODUCTNAME_SEARCH ="productname_search";


    @Transactional
    public Product addProduct(Product product, Long categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        product.setCategory(optionalCategory.get());
        return productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public List<Product> getProductAll(){
        return productRepository.findAll();
    }


    @Transactional(readOnly = true )
    public List<Product> getProducts(int page, Long categoryId, String searchKind, String searchStr) {
        int limit = 16;
        int start = page *limit -limit;
        return productRepository.getProducts(categoryId, start,limit, searchKind,searchStr);
    }
}
