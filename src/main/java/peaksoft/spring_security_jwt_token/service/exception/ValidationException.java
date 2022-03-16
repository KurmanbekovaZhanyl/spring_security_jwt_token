package peaksoft.spring_security_jwt_token.service.exception;

public class ValidationException extends RuntimeException{

    public ValidationException(String message) {
        super(message);
    }
}
