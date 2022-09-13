package cheetos.main.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cheetos.main.post.domain.Content;

public interface ContentRepository extends JpaRepository<Content, Long> {

}
