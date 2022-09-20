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
public class Provider {

    @Column(name = "auth_provider")
    private String provider;

    public Provider(String provider) {
        this.provider = provider;
    }
}
