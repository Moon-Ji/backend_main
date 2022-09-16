package cheetos.main.post.service;

import cheetos.main.post.dto.request.GetPostDto;
import cheetos.main.post.dto.request.WritePostDto;
import cheetos.main.user.User;

public interface PostWriteService extends PostService{


    // 메인화면에서 포스트 정보를 불러옴
    GetPostDto.MainPostDataRes getMainPostInfo(Long userId);

    // 포스트를 작성
    void writePost(WritePostDto.WritePost writePost, User user);
}
