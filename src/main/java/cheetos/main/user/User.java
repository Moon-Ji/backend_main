package cheetos.main.user;

import cheetos.main.post.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cheetos.main.common.BaseTimeEntity;
import cheetos.main.user.domain.Email;
import cheetos.main.user.domain.NickName;
import cheetos.main.user.domain.Provider;
import cheetos.main.user.domain.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Embedded
    private Email email;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "profile_img")
    private String profileImg;

    @Column(name = "user_roles")
    private Role userRole;

    @Column(name = "birth_day")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String birthDay;

    @Column(name = "auth_provider")
    private Provider authProvider;


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
