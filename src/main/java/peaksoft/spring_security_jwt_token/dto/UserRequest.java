package peaksoft.spring_security_jwt_token.dto;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Data
@Getter
@Setter
public class UserRequest {

   @NotNull
   @Email
   private String email;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String password;
    private String repeatPassword;
    private String address;


}
