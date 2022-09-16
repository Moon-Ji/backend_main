package cheetos.main.post.domain;

import cheetos.main.post.dto.request.WritePostDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cheetos.main.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "content")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Content extends BaseTimeEntity {

    @Id
    @Column(name = "content_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentId;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post postId;

    @Column(name = "img")
    private String img;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime endDate;

    @Builder
    public Content (Long contentId, Post postId, String img, String description, LocalDateTime startDate, LocalDateTime endDate) {
        this.contentId = contentId;
        this.img = img;
        this.description = description;
        this.postId = postId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Content of (WritePostDto.writeContent content, String convertToImgUrl) {
        return Content
            .builder()
            .img(convertToImgUrl)
            .description(content.getDescription())
            .build();
    }

    public void setPostId (Post post) {
        this.postId = post;
        post.getContents().add(this);
    }
}
