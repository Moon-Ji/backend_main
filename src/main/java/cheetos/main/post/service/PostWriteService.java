package cheetos.main.post.service;

import cheetos.main.post.dto.request.WritePostDto;
import cheetos.main.user.domain.User;

public interface PostWriteService extends PostService {



    // 포스트를 작성
    void writePost(WritePostDto.WritePost writePost, User user);

}
