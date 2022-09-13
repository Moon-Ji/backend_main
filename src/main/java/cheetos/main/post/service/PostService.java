package cheetos.main.post.service;

import cheetos.main.post.dto.GetPostDto;

public interface PostService {

    GetPostDto.MainPostDataRes getMainPostInfo(Long userId);
}
