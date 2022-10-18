package cheetos.main.user.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Email {

    @Column(name = "email")
    private String email;

    public Email(String email) {
        validate(email);
        this.email = email;
    }
    private void validate(String email) {

    }

}
