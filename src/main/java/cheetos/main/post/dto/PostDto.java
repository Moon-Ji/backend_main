package cheetos.main.post.dto;

import java.util.ArrayList;
import java.util.List;

import cheetos.main.post.domain.Post;
import cheetos.main.post.enums.LocalCodes;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

public class PostDto {

    @Getter
    @ToString
    public static class MainPostDataRes {

        private List<LocationInfo> map = new ArrayList<>();

        public MainPostDataRes(List<LocationInfo> list) {
            this.map = list;
        }

        public static MainPostDataRes of (List<LocationInfo> list) {
            return new MainPostDataRes(list);
        }

    }

    @Getter
    @ToString
    public static class LocationInfo {

        @ApiModelProperty("지역코드")
        private LocalCodes location;

        @ApiModelProperty("게시글 대표이미지")
        private String representImg;

        @Builder
        public LocationInfo(LocalCodes location, String representImg) {
            this.location = location;
            this.representImg = representImg;
        }

        public static LocationInfo of (Post post) {
            return LocationInfo
                .builder()
                .location(post.getLocation())
                .representImg(post.getRepresentImg())
                .build();
        }
    }
}
