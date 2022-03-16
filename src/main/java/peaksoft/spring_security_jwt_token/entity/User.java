package peaksoft.spring_security_jwt_token.entity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="users")
@Data
@RequiredArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_sequence")
    @SequenceGenerator(name="user_sequence",
            sequenceName = "user_seq",
            allocationSize = 1)


    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private boolean enabled=true;

    @ManyToMany(targetEntity = Role.class,cascade = {CascadeType.PERSIST,
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},
            fetch = FetchType.EAGER)


    @JoinTable(name="users_roles",
    joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name="role_id")})

    private List<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>() ;
        for (Role role : roles) {
         grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return grantedAuthorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
