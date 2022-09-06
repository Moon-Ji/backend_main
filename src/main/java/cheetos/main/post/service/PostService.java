package cheetos.main.post.service;

import org.springframework.stereotype.Service;

import cheetos.main.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post>
}
