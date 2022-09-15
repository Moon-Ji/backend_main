package cheetos.main.post.service;

import cheetos.main.Exception.S3ConvertImgException;
import cheetos.main.post.domain.Content;
import cheetos.main.post.domain.Post;
import cheetos.main.post.dto.WritePostDto;
import cheetos.main.post.dto.WritePostDto.WritePost;
import cheetos.main.post.dto.WritePostDto.writeContent;
import cheetos.main.post.repository.ContentRepository;
import java.util.List;

import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import cheetos.main.post.dto.GetPostDto;
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

    private final ContentRepository contentRepository;

    /**
     * 유저가 로딩할 게시글 메인정보 리스트 반환
     * TODO : 로그인 상태에 따라 갖고오는 유저 정보를 바탕으로 바꾸기
     * @return
     */
    @Transactional(readOnly = true)
    public GetPostDto.MainPostDataRes getMainPostInfo(Long userId) {
        List<GetPostDto.LocationInfo> postList = postRepository
            .findAllByUserId(userId).stream().map(GetPostDto.LocationInfo::of).toList();
        return GetPostDto.MainPostDataRes.of(postList);
    }

    /**
     * 포스트 작성 로직
     * TODO : AWS S3 이미지 업로드 연동 구현 필요
     */
    @Transactional
    public void writePost (WritePostDto.WritePost writePost) {

        //컨텐츠를 저장
        List<Content> contents = saveContents(writePost.getContents());
        // 포스트를 저장
        savePost(writePost, contents);

        log.info("[POST] 포스트 저장 완료");
    }

    /**
     * 포스트 저장
     */
    @Transactional
    public void savePost (WritePost writePost, List<Content> contents) {

        // 대표이미지 url 로 변환
        String representImg = convertImgToUrl(writePost.getRepresentImg());

        // 포스트 저장
        Post.of(writePost,contents,representImg);
    }


    /**
     * 컨텐츠 리스트 반환
     * @param writeContentList
     */
    @Transactional
    public List<Content> saveContents (List<writeContent> writeContentList) {

        // 컨텐츠로 변환
        List<Content> contents = writeContentList.stream().map(it ->
            {
                // 이미지를 url로 변환
                String convertedImgUrl = convertImgToUrl(it.getImg());
                return Content.of(it, convertedImgUrl);
            }).collect(Collectors.toList());

        // 컨텐츠 저장
        contentRepository.saveAll(contents);
        return contents;
    }

    /**
     * 이미지를 S3 업로드 후 url 반환
     * @param imgFile
     * @return
     */
    private String convertImgToUrl (MultipartFile imgFile) {

        String convertedImgUrl = null;
        try {
            convertedImgUrl = imgService.uploadImgToS3(imgFile);
        } catch (S3ConvertImgException e) {
            log.error("이미지 URL로 변환중 에러가 발생하였습니다!");
            throw new S3ConvertImgException("이미지 변환중 에러가 발생하였습니다!");
        }
        return convertedImgUrl;
    }
}
