package cheetos.main.user.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import cheetos.main.common.BaseTimeEntity;
import cheetos.main.post.enums.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "users")
//@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "profile_img")
    private String profileImg;

    @Enumerated(EnumType.STRING)
    @Setter
    @Column(name = "user_roles")
    private Role userRole;

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

    @Column(name = "birth_day")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String birthDay;


    @Builder
    public User(Long id, NickName nickName, Email email, String name, Gender gender, String profileImg,
    Role userRole, String birthDay, Provider authProvider) {
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.name = name;
        this.gender = gender;
        this.profileImg = profileImg;
        this.userRole = userRole;
        this.birthDay = birthDay;
        this.authProvider = authProvider;
    }
}
