package my.examples.JBCmart.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class ProductDetailId implements Serializable {
    private String productSize;
    private String productColor;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
