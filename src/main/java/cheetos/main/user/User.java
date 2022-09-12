package cheetos.main.user;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cheetos.main.common.BaseTimeEntity;
import cheetos.main.user.domain.Email;
import cheetos.main.user.domain.NickName;
import cheetos.main.user.domain.PhoneNumber;
import cheetos.main.user.domain.Provider;
import cheetos.main.user.domain.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Embedded
    private NickName nickName;

    @Column(name = "email")
    private Email email;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private PhoneNumber phoneNumber;

    @Column(name = "profile_img")
    private String profileImg;

    @Column(name = "user_roles")
    private Role userRole;

    @Column(name = "auth_provider")
    private Provider authProvider;
}
