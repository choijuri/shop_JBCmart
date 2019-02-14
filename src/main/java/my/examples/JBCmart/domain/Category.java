package my.examples.JBCmart.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="category")
@Getter
@Setter
public class Category {
    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;

    public Category() {
        productList = new ArrayList<>();
    }
}

