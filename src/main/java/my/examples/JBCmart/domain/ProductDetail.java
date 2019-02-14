package my.examples.JBCmart.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="product_detail")
@Getter
@Setter
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가.
    private String productColor;
    private String productQuantity;
    private String productSize;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
}
