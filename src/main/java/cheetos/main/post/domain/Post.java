package cheetos.main.post.domain;

import cheetos.main.post.dto.WritePostDto.WritePost;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import cheetos.main.common.BaseTimeEntity;
import cheetos.main.post.enums.LocalCodes;
import cheetos.main.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Table(name = "post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTimeEntity {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @JoinColumn(name = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "postId")
    private List<Content> contents ;

    @Column(name = "location")
    @Enumerated(EnumType.STRING)
    private LocalCodes location;

    @Column(name = "title")
    private String title;

    @Column(name = "represent_img")
    private String representImg;

    @Column(name = "start_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime endDate;

    @Builder
    public Post (Long postId, User userId, List<Content> contents, LocalCodes location, String title
    ,String representImg, LocalDateTime startDate, LocalDateTime endDate) {
        this.postId = postId;
        this.userId = userId;
        this.contents = contents;
        this.location = location;
        this.title = title;
        this.representImg = representImg;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Post of (WritePost writePost, List<Content> contents, String convertedImgUrl) {
        return Post
            .builder()
            .location(writePost.getLocation())
            .title(writePost.getTitle())
            .contents(contents)
            .representImg(convertedImgUrl)
            .startDate(writePost.getStartDate())
            .endDate(writePost.getEndDate())
            .build();
    }



//    public void setContents(List<Content> contents) {
//        for (Content content : contents) {
//            content.setPost(this);
//        }
//    }
}
