package cheetos.main.user.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public enum Provider {
    GOOGLE,
    FACEBOOK,
    NAVER,
    KAKAO;

}
