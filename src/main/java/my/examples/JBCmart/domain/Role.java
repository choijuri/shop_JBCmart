package my.examples.JBCmart.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Setter
@Getter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가.
    private Long id;
    @Column(length = 255)
    private String name;


}