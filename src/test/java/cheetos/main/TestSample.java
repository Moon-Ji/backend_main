package cheetos.main;

import cheetos.main.post.enums.Gender;
import cheetos.main.user.User;
import cheetos.main.user.domain.Email;
import cheetos.main.user.domain.NickName;

public class TestSample {

    protected static User user1() {
        return User
            .builder()
            .nickName(new NickName("쿠쿠"))
            .email(new Email("runnz121@gmail.com"))
            .name("쿠쿠")
            .gender(Gender.MAN)
            .profileImg("cdn/url")
            .build();
    }

}
