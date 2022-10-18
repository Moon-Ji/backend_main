package cheetos.main.post.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cheetos.main.Exception.NotFoundException;
import cheetos.main.post.domain.Post;
import cheetos.main.post.dto.response.GetPostDto;
import cheetos.main.post.enums.ErrorCode;
import cheetos.main.post.enums.LocalCodes;
import cheetos.main.post.repository.ContentRepository;
import cheetos.main.post.repository.PostRepository;
import cheetos.main.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostReadServiceImpl implements PostReadService {

    private final PostRepository postRepository;
    private final ContentRepository contentRepository;
    private final UserRepository userRepository;

    /**
     * 유저가 로딩할 게시글 메인정보 리스트 반환
     * TODO : 로그인 상태에 따라 갖고오는 유저 정보를 바탕으로 바꾸기
     * @return 메인정보리스트 반환
     */
    @Override
    @Transactional(readOnly = true)
    public GetPostDto.MainPostDataRes getMainPostInfo(Long userId) {
        List<GetPostDto.LocationInfoRes> postList = postRepository
            .findAllByUserId(userId).stream()
            .map(GetPostDto.LocationInfoRes::of)
            .toList();
        return GetPostDto.MainPostDataRes.of(postList);
    }

    /**
     * 지역코드를 기반으로 해당 지역 포스트를 갖고옴
     * @param localCodes 지역코드
     * @return 해당 지역 포스트 반환
     */
    @Override
    public GetPostDto.LocalPostDataRes getLocalPostData(LocalCodes localCodes) {
        List<GetPostDto.LocalPost> localPosts = postRepository
            .findAllByLocation(localCodes).stream()
            .map(GetPostDto.LocalPost::of)
            .collect(Collectors.toList());
        return GetPostDto.LocalPostDataRes.of(localCodes, localPosts);
    }

    /**
     * 상세 포스트를 반환함
     * @param post 포스트아이디
     * @return 상세 포스트 반환
     */
    @Override
    public GetPostDto.PostDetailRes getPostDetail(Post post) {
        List<GetPostDto.ContentsDetailRes> findContents = contentRepository
            .findAllByPostId(post).stream()
            .map(GetPostDto.ContentsDetailRes::of)
            .toList();

        Post findPost = postRepository.findById(post.getPostId())
            .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_POST_ERROR));

        return GetPostDto.PostDetailRes.of(findPost, findContents);
    }

}
