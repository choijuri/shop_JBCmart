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
    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price")
    private long productPrice;
    @Column(name = "reg_date")
    private Date regDate;

    @ManyToOne
    @JoinColumn(name ="category_id")
    private Category category;

    @OneToMany(mappedBy = "product",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<ProductDetail> productDetails;

    @OneToMany(mappedBy = "product",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<ImageFile> imageFiles;

    public Product(){
        productDetails = new ArrayList<>();
        imageFiles = new ArrayList<>();
        regDate = new Date();
    }

    public void addImageFile(ImageFile imageFile) {
        if(imageFiles == null)
            imageFiles = new ArrayList<>();
        imageFile.setProduct(this); // 쌍방향이기 때문에 this를 참조하도록 한다.
        imageFiles.add(imageFile);
    }
}
