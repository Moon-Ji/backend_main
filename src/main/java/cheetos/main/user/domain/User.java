package cheetos.main.user.domain;

import javax.persistence.*;

import cheetos.main.common.BaseTimeEntity;
import cheetos.main.user.domain.Email;
import cheetos.main.user.domain.NickName;
import cheetos.main.user.domain.Provider;
import cheetos.main.user.domain.Role;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
//@RequiredArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Embedded
    private NickName nickName;

    @Embedded
    private Email email;

    @Column(name = "name")
    private String name;

    private String gender;

    @Column(name = "profile_img")
    private String profileImg;

    @Enumerated(EnumType.STRING)
    @Setter
    @Column(name = "user_roles")
    private Role userRole;

    private String birthDay;

    @Enumerated(EnumType.STRING)
    @Setter
    @Column(name = "auth_provider")
    private Provider authProvider;

    @Builder(builderClassName="OAuth2Register", builderMethodName = "oauth2Register")
    public User(String nickName, String email, Role role, Provider authProvider) {
        this.nickName = new NickName(nickName);
        this.email = new Email(email);
        this.userRole = role;
        this.authProvider = authProvider;
    }
}
