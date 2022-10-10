package cheetos.main.post.controller;

import cheetos.main.post.dto.request.WritePostDto.WritePost;
import cheetos.main.post.enums.Gender;
import cheetos.main.post.enums.LocalCodes;
import cheetos.main.post.repository.PostRepository;
import cheetos.main.post.service.PostReadService;
import cheetos.main.post.service.PostWriteService;
import cheetos.main.user.User;
import cheetos.main.user.domain.Email;
import cheetos.main.user.domain.NickName;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cheetos.main.common.ResponseForm;
import cheetos.main.post.dto.response.GetPostDto;
import cheetos.main.post.service.PostWriteServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags = {"게시물 API"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostWriteServiceImpl postWriteServiceImpl;

    private final PostReadService postReadService;

    private final PostWriteService postWriteService;

    private static final Long TEST_USER_ID = 123L;

    /**
     * 토큰값으로 유저정보 파악 후 반환
     * @return
     */
    @GetMapping("/main")
    @ApiOperation(value = "유저별 메인화면 지도 정보", response = GetPostDto.MainPostDataRes.class, responseContainer = "List")
    public ResponseForm getMainPage() {
        return new ResponseForm(postReadService.getMainPostInfo(TEST_USER_ID));
    }

    /**
     * 사진, 글 업로드 생성
     */
    @PostMapping("/write")
    @ApiOperation(value = "포스트 작성 컨트롤러")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseForm createPost(@ModelAttribute WritePost writePost) {
        /**
         * 삭제 필요
         */
        User user = User
            .builder()
            .nickName(new NickName("쿠쿠"))
            .email(new Email("runnz121@gmail.com"))
            .name("쿠쿠")
            .gender(Gender.MAN)
            .profileImg("cdn/url")
            .build();
        ;
        postWriteService.writePost(writePost, user);
        return new ResponseForm();
    }

    /**
     * 지역 데이터 요청하기
     */
    @GetMapping("/local")
    @ApiOperation(value = "지역 데이터 요청하기")
    public ResponseForm getLocalDate(@PathVariable LocalCodes localCodes) {
        return new ResponseForm(postReadService.getLocalPostData(localCodes));
    }

    /**
     * 상세 포스트 반환
     */
    @GetMapping("/detail")
    @ApiOperation(value = "상세포스트 반환")
    public ResponseForm getPostDetail(@RequestParam Long postId) {
        return new ResponseForm(postReadService.getPostDetail(postId));
    }

}
