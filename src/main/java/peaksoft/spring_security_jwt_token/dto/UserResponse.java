package peaksoft.spring_security_jwt_token.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private boolean enabled;



}
