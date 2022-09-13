package cheetos.main.post.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cheetos.main.post.dto.GetPostDto;
import cheetos.main.post.repository.ContentRepository;
import cheetos.main.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ContentRepository contentRepository;

    /**
     * 유저가 로딩할 게시글 메인정보 리스트 반환
     * TODO : 로그인 상태에 따라 갖고오는 유저 정보를 바탕으로 바꾸기
     * @return
     */
    @Override
    public GetPostDto.MainPostDataRes getMainPostInfo(Long userId) {
        List<GetPostDto.LocationInfo> postList = postRepository
            .findAllByUserId(userId).stream().map(GetPostDto.LocationInfo::of).toList();
        return GetPostDto.MainPostDataRes.of(postList);
    }


}
