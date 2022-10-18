package cheetos.main.post.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cheetos.main.post.domain.Content;
import cheetos.main.post.domain.Post;

public interface ContentRepository extends JpaRepository<Content, Long> {

    List<Content> findAllByPostId(Post postId);
}
