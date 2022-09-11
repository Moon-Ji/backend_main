package cheetos.main.post.service;

import java.util.List;

import cheetos.main.post.domain.Post;
import cheetos.main.post.dto.PostDto;

public interface PostService {

    PostDto.MainPostDataRes getMainPostInfo(Long userId);
}
