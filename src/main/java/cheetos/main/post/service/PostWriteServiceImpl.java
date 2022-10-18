package cheetos.main.post.service;

import static cheetos.main.post.enums.ErrorCode.*;

import cheetos.main.Exception.S3ConvertImgException;
import cheetos.main.post.domain.Content;
import cheetos.main.post.domain.Post;
import cheetos.main.post.dto.request.WritePostDto;
import cheetos.main.post.dto.request.WritePostDto.WritePost;
import cheetos.main.post.dto.request.WritePostDto.writeContent;
import cheetos.main.post.repository.ContentRepository;
import cheetos.main.user.User;
import cheetos.main.user.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import cheetos.main.post.dto.response.GetPostDto;
import cheetos.main.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostWriteServiceImpl implements PostWriteService {

    private final ImgService imgService;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ContentRepository contentRepository;

    /**
     * 포스트 작성 로직
     * TODO : AWS S3 이미지 업로드 연동 구현 필요
     */
    @Transactional
    public void writePost(WritePostDto.WritePost writePost, User user1) {

        User user = userRepository.findById(3L).orElse(null);

        List<Content> lists = writePost
            .getContents()
            .stream()
            .map(it -> Content.of(it, convertImgToUrl(writePost.getRepresentImg())))
            .toList();

        Post post = new Post();
        for (Content content : lists) {
            content.setPostId(post);
        }

        post.setUser(user);
        postRepository.save(post);

        log.info("[POST] 포스트 저장 완료");
    }

    /**
     * 이미지를 S3 업로드 후 url 반환
     * @param imgFile
     * @return
     */
    private String convertImgToUrl(MultipartFile imgFile) {

        String convertedImgUrl = null;
        try {
            convertedImgUrl = imgService.uploadImgToS3(imgFile);
        } catch (S3ConvertImgException e) {
            log.error("[Convert Img Url] 이미지 URL로 변환중 에러가 발생하였습니다!");
            throw new S3ConvertImgException(S3_CONVERT_ERROR);
        }
        return convertedImgUrl;
    }
}
