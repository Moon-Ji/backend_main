package cheetos.main.post.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cheetos.main.common.ResponseForm;
import cheetos.main.post.domain.Post;
import cheetos.main.post.service.PostServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags = {"게시물 API"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostServiceImpl postServiceImpl;

    private static final Long TEST_USER_ID = 123L;

    /**
     * 토큰값으로 유저정보 파악 후 반환
     * @return
     */
    @GetMapping("/main")
    @ApiOperation(value = "유저별 메인화면 지도 정보", response = Post.class, responseContainer = "List")
    public ResponseForm getMainPage() {
        return new ResponseForm(postServiceImpl.getMainPostInfo(TEST_USER_ID));
    }





}
