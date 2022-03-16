package peaksoft.spring_security_jwt_token.service.exception.validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import peaksoft.spring_security_jwt_token.dto.UserRequest;
import peaksoft.spring_security_jwt_token.entity.User;
import peaksoft.spring_security_jwt_token.repository.UserRepository;
import peaksoft.spring_security_jwt_token.service.exception.ValidationException;
import peaksoft.spring_security_jwt_token.service.exception.ValidationExceptionType;


@Component
@RequiredArgsConstructor
public class UserRequestValidator {

    private final UserRepository repository;

    public void validate(User registered, UserRequest request){
        if (request ==null || registered ==null) {
            throw new ValidationException(ValidationExceptionType.BAD_REQUEST);
        }
        if (repository.findByEmail(request.getEmail()).isPresent()) {
            throw new ValidationException(ValidationExceptionType.EMAIL_ALREADY_EXIST);
        }
        if (! request.getPassword().equals(request.getRepeatPassword())) {
            throw new ValidationException(ValidationExceptionType.PASSWORD_DONT_MATCH);
        }
    }
}
