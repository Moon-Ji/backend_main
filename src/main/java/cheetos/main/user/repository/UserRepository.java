package cheetos.main.user.repository;

import cheetos.main.user.User;
import cheetos.main.user.domain.Email;
import cheetos.main.user.domain.NickName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // SELECT * FROM user WHERE nickName = ?1
    User findByNickName(NickName nickName);

    User findByEmail(Email email);

}
