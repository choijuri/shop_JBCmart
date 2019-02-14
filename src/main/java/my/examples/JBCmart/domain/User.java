package my.examples.JBCmart.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="user")
@Getter
@Setter
public class User {
    @Id
    @Column(name ="user_id")
    private String userId;
    private String name;
    private String email;
    private String passwd;
    private String phone;
    @Column(name ="reg_date")
    private Date regDate;

    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Set<Role> roles;

    public User(){
        regDate = new Date();
    }


    public void addRole(Role role) {
        if(roles == null)
            roles = new HashSet<>();
        roles.add(role);
    }
}
