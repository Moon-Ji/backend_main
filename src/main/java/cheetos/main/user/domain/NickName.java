package cheetos.main.user.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NickName {

    private static final int MAX_LENGTH = 8;
    private static final int MIN_LENGTH = 3;

    @Column(name = "nick_name")
    private String nickName;

    public NickName(String nickName) {
        validate(nickName);
        this.nickName = nickName;
    }

    //TODO : 닉네임 글자수 혹은 닉네임 제한 조건 확인
    private void validate(String nickName) {

    }
}
