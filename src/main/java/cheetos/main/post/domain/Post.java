package cheetos.main.post.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import cheetos.main.common.BaseTimeEntity;
import cheetos.main.post.dto.request.WritePostDto.WritePost;
import cheetos.main.post.enums.LocalCodes;
import cheetos.main.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "post")
@NoArgsConstructor
public class Post extends BaseTimeEntity {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;


    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId", orphanRemoval = true)
    private List<Content> contents = new ArrayList<>();

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
    public Post(Long postId, User userId, List<Content> contents, LocalCodes location, String title
        , String representImg, LocalDateTime startDate, LocalDateTime endDate) {
        this.postId = postId;
        this.userId = userId;
        this.contents = contents;
        this.location = location;
        this.title = title;
        this.representImg = representImg;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Post of(WritePost writePost, String convertedImgUrl, User user) {
        return Post
            .builder()
            .userId(user)
            .location(writePost.getLocation())
            .title(writePost.getTitle())
            .representImg(convertedImgUrl)
            .startDate(writePost.getStartDate())
            .endDate(writePost.getEndDate())
            .build();
    }

    public static Post from(Long postId) {
        return Post.builder().postId(postId).build();
    }

    /**
     * contents 연관관계 맵핑
     */
    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public void setUser(User user) {
        this.userId = user;
    }
}
