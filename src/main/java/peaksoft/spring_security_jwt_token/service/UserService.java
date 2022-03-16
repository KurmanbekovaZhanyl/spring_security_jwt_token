package peaksoft.spring_security_jwt_token.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.spring_security_jwt_token.dto.UserRequest;
import peaksoft.spring_security_jwt_token.dto.UserResponse;
import peaksoft.spring_security_jwt_token.entity.User;
import peaksoft.spring_security_jwt_token.mapper.UserEditMapper;
import peaksoft.spring_security_jwt_token.mapper.UserViewMapper;
import peaksoft.spring_security_jwt_token.repository.UserRepository;
import peaksoft.spring_security_jwt_token.service.exception.validator.UserRequestValidator;
import static java.lang.String.format;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final UserEditMapper editMapper;
    private final UserViewMapper viewMapper;
    private final UserRequestValidator requestValidator;

    private final PasswordEncoder passwordEncoder;

    public UserResponse create(User registeredUser, UserRequest request) {
        requestValidator.validate(registeredUser, request);
        User user = editMapper.create(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        repository.save(user);
        return viewMapper.viewUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email).
                orElseThrow(() ->
        new UsernameNotFoundException(format("User with email -%s, not found",email)));
    }
}
