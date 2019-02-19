package my.examples.JBCmart.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="product_detail")
@Getter
@Setter
public class ProductDetail {
    @EmbeddedId
    private ProductDetailId productDetailId;
    private Long productQuantity;

    public ProductDetail(){
    }

}
