package my.examples.JBCmart.repository.custom;

import com.querydsl.jpa.JPQLQuery;
import my.examples.JBCmart.domain.Product;
import my.examples.JBCmart.domain.QProduct;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ProductRepositoryImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom {

    public ProductRepositoryImpl(){
        super(Product.class);
    }


    @Override
    public List<Product> getProducts(Long categoryId, int start, int limit, String searchKind, String searchStr) {

        // JPQL
        // SELECT distinct p FROM Post p INNER JOIN FETCH p.account INNER JOIN FETCH p.category ORDER BY p.id DESC
        // SELECT distinct p FROM Post p INNER JOIN FETCH p.account INNER JOIN FETCH p.category WHERE p.category.id = :categoryId ORDER BY p.id DESC
        // SELECT distinct p FROM Post p INNER JOIN FETCH p.account INNER JOIN FETCH p.category WHERE p.account.name = :searchStr ORDER BY p.id DESC
        // SELECT distinct p FROM Post p INNER JOIN FETCH p.account INNER JOIN FETCH p.category WHERE p.category.id = :categoryId and p.account.name = :searchStr ORDER BY p.id DESC


        QProduct qProduct = QProduct.product;
        JPQLQuery<Product> jpqlQuery = from(qProduct).innerJoin(qProduct.category).fetchJoin().distinct();

        if(categoryId != null){
            jpqlQuery.where(qProduct.category.id.eq(categoryId));
        }

        searchWhere(searchKind,searchStr,qProduct,jpqlQuery);

        jpqlQuery.orderBy(qProduct.productId.desc());
        jpqlQuery.offset(start).limit(limit);
        return jpqlQuery.fetch();
    }



    @Override
    public Long getProductsCount(Long categoryId, String searchKind, String searchStr) {

        // JPQL
        // SELECT distinct p FROM Post p INNER JOIN FETCH p.account INNER JOIN FETCH p.category ORDER BY p.id DESC
        // SELECT distinct p FROM Post p INNER JOIN FETCH p.account INNER JOIN FETCH p.category WHERE p.category.id = :categoryId ORDER BY p.id DESC
        // SELECT distinct p FROM Post p INNER JOIN FETCH p.account INNER JOIN FETCH p.category WHERE p.account.name = :searchStr ORDER BY p.id DESC
        // SELECT distinct p FROM Post p INNER JOIN FETCH p.account INNER JOIN FETCH p.category WHERE p.category.id = :categoryId and p.account.name = :searchStr ORDER BY p.id DESC
        // ....

        QProduct qProduct = QProduct.product;
        JPQLQuery<Product> jpqlQuery = from(qProduct).innerJoin(qProduct.category);

        if (categoryId != null) {
            jpqlQuery.where(qProduct.category.id.eq(categoryId));
        }
        searchWhere(searchKind,searchStr,qProduct,jpqlQuery);

        return jpqlQuery.fetchCount();
    }

    private void searchWhere(String searchKind, String searchStr, QProduct qProduct, JPQLQuery<Product> jpqlQuery) {
        if ("PRODUCTID_SEARCH".equals(searchKind)) {
            jpqlQuery.where(qProduct.productId.like("%" + searchStr + "%"));
        } else if ("PRODUCTNAME_SEARCH".equals(searchKind)) {
            jpqlQuery.where(qProduct.productName.like("%" + searchStr + "%"));
        }
    }
}
