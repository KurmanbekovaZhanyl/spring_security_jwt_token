package peaksoft.spring_security_jwt_token.mapper;
import org.springframework.stereotype.Component;
import peaksoft.spring_security_jwt_token.dto.UserResponse;
import peaksoft.spring_security_jwt_token.entity.User;

@Component
public class UserViewMapper {

    public UserResponse viewUser(User user) {
        if (user == null) {
            return null;
        }
        UserResponse response = new UserResponse();
        if (user.getId() != null) {
            response.setId(String.valueOf(user.getId()));
        }
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setAddress(user.getAddress());
        response.setEnabled(user.isEnabled());
        return response;
    }



}
