package cheetos.main.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cheetos.main.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
    List<Post> findAllByUserId(Long userId);
}
