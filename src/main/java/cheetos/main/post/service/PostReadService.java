package cheetos.main.post.service;

import cheetos.main.post.dto.response.GetPostDto;
import cheetos.main.post.enums.LocalCodes;

public interface PostReadService extends PostService{

    // 메인화면에서 포스트 정보를 불러옴
    GetPostDto.MainPostDataRes getMainPostInfo(Long userId);

    // 지역 데이터 요쳥하기
    GetPostDto.LocalPostDataRes getLocalPostData(LocalCodes localCodes);

    // 상세 포스트 반환하기
    GetPostDto.PostDetailRes getPostDetail(Long postId);

}
