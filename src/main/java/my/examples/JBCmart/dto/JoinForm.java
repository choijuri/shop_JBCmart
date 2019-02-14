package my.examples.JBCmart.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class JoinForm {
    @NotNull
    @Size(min=3, max=30)
    private String userId;
    @NotNull
    @Size(min=2, max=30)
    private String name;
    @NotNull
    @Size(min=4, max=12)
    private String password;
    @NotNull
    @Size(min=4, max=12)
    private String password2;
    @NotNull
    @Size(min=4, max=255)
    private String email;
    @NotNull
    @Size(min=1, max=20)
    private String phone;

}
