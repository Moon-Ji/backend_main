package cheetos.main.user.service;

import cheetos.main.user.domain.NickName;
import cheetos.main.user.domain.User;
import cheetos.main.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(String nickName) {
        return userRepository.findByNickName(new NickName(nickName));
    }

}
