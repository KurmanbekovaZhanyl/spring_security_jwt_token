package peaksoft.spring_security_jwt_token.mapper;
import org.springframework.stereotype.Component;
import peaksoft.spring_security_jwt_token.dto.UserRequest;
import peaksoft.spring_security_jwt_token.entity.User;


@Component
public class UserEditMapper {

    public User create(UserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setAddress(request.getAddress());
        user.setEnabled(user.isEnabled());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        return user;


    }


}

