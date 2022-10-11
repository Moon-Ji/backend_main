package cheetos.main.post.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import cheetos.main.post.domain.Content;
import cheetos.main.post.domain.Post;
import cheetos.main.post.enums.LocalCodes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class GetPostDto {

    /**
     * 메인 지도 데이터 전체 반환 -- 1
     */
    @Getter
    @ToString
    public static class MainPostDataRes {

        private List<LocationInfoRes> map;

        public MainPostDataRes(List<LocationInfoRes> list) {
            this.map = list;
        }

        public static MainPostDataRes of(List<LocationInfoRes> list) {
            return new MainPostDataRes(list);
        }

    }

    /**
     * 각 지역별 대표이미지, 지역코드 반환 -- 1-1
     */
    @Getter
    @ToString
    public static class LocationInfoRes {

        @ApiModelProperty("지역코드")
        private LocalCodes location;

        @ApiModelProperty("게시글 대표이미지")
        private String representImg;

        @Builder
        public LocationInfoRes(LocalCodes location, String representImg) {
            this.location = location;
            this.representImg = representImg;
        }

        public static LocationInfoRes of(Post post) {
            return LocationInfoRes
                .builder()
                .location(post.getLocation())
                .representImg(post.getRepresentImg())
                .build();
        }
    }

    /**
     * 지역 데이터 요청반환값(지역) -- 2
     */
    @Getter
    @ToString
    public static class LocalPostDataRes {

        @ApiModelProperty("지역이름")
        private String locationName;

        @ApiModelProperty("지역 포스트 리스트")
        private List<LocalPost> post;

        @Builder
        public LocalPostDataRes(String locationName, List<LocalPost> post) {
            this.locationName = locationName;
            this.post = post;
        }

        public static LocalPostDataRes of(LocalCodes localCodes, List<LocalPost> post) {
            return LocalPostDataRes
                .builder()
                .locationName(localCodes.getName())
                .post(post)
                .build();
        }
    }

    /**
     * 지역 포스트 반환값 -- 2-1
     */
    @Getter
    @ToString
    public static class LocalPost {

        @ApiModelProperty("포스트아이디")
        private Long postId;

        @ApiModelProperty("제목")
        private String title;

        @ApiModelProperty("이미지")
        private String img;

        @ApiModelProperty("여행 시작날짜")
        private LocalDateTime startDate;

        @ApiModelProperty("여행 종료날짜")
        private LocalDateTime endDate;

        @Builder
        public LocalPost(Long postId, String title, String img, LocalDateTime startDate, LocalDateTime endDate) {
            this.postId = postId;
            this.title = title;
            this.img = img;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public static LocalPost of(Post post) {
            return LocalPost
                .builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .img(post.getRepresentImg())
                .startDate(post.getStartDate())
                .endDate(post.getEndDate())
                .build();
        }
    }

    /**
     * 상세 포스트 반환값 -- 3
     */
    @Getter
    @ToString
    public static class PostDetailRes {

        @ApiModelProperty("제목")
        private String title;

        @ApiModelProperty("시작날짜")
        private LocalDateTime startDate;

        @ApiModelProperty("종료날짜")
        private LocalDateTime endDate;

        @ApiModelProperty("작성날짜")
        private LocalDateTime createDate;

        @ApiModelProperty("상세컨텐츠")
        private List<ContentsDetailRes> contents;

        @Builder
        public PostDetailRes(String title, LocalDateTime startDate, LocalDateTime endDate, LocalDateTime createDate,
            List<ContentsDetailRes> contents) {
            this.title = title;
            this.startDate = startDate;
            this.endDate = endDate;
            this.createDate = createDate;
            this.contents = contents;
        }

        public static PostDetailRes of(Post post, List<ContentsDetailRes> contents) {
            return PostDetailRes
                .builder()
                .title(post.getTitle())
                .startDate(post.getStartDate())
                .endDate(post.getEndDate())
                .createDate(post.getCreatedAt())
                .contents(contents)
                .build();
        }
    }

    /**
     * 포스트 내부의 상세 콘텐츠 -- 3-1
     */
    @Getter
    @ToString
    public static class ContentsDetailRes {

        @ApiModelProperty("이미지")
        private String img;

        @ApiModelProperty("내용")
        private String description;

        @Builder
        public ContentsDetailRes(String img, String description) {
            this.img = img;
            this.description = description;
        }

        public static ContentsDetailRes of(Content content) {
            return ContentsDetailRes
                .builder()
                .img(content.getImg())
                .description(content.getDescription())
                .build();
        }
    }
}
