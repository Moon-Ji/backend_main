package cheetos.main.user.service;

import cheetos.main.user.User;
import cheetos.main.user.domain.NickName;
import cheetos.main.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

//    public User findUserByNickName(String nickName) {
//        return userRepository.findByNickName(new NickName(nickName))
//                .stream()
//                .findAny()
//                .orElseThrow();
//    }

}
