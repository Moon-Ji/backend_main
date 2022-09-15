package cheetos.main.post.dto;

import cheetos.main.post.domain.Content;
import cheetos.main.post.enums.LocalCodes;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import jdk.jfr.Timespan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

public class WritePostDto {

    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WritePost {


        @Enumerated(EnumType.STRING)
        @ApiModelProperty(value = "지역")
        private LocalCodes location;

        @ApiModelProperty(value = "대표이미지")
        private MultipartFile representImg;

        @ApiModelProperty(value = "제목")
        private String title;

        @ApiModelProperty(value = "여행 시작날짜")
        private LocalDateTime startDate;

        @ApiModelProperty(value = "여행 종료날짜")
        private LocalDateTime endDate;

        @ApiModelProperty(value = "컨텐츠")
        private List<writeContent> contents;
    }

    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class writeContent {

        @ApiModelProperty(value = "이미지")
        private MultipartFile img;

        @ApiModelProperty(value = "컨텐츠 설명")
        private String description;

    }
}
