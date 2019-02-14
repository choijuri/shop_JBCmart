package my.examples.JBCmart.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="product")
@Getter
@Setter
public class Product {
    @Id
    private String productId;
    private String productName;
    private long productPrice;
    private Date regDate;

    @ManyToOne
    @JoinColumn(name ="category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<ProductDetail> productDetails;

    public Product(){
        productDetails = new ArrayList<>();
        regDate = new Date();
    }
}
