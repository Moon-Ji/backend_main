package cheetos.main.post.domain;

import cheetos.main.post.dto.WritePostDto;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "content")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Content extends BaseTimeEntity {

    @Id
    @Column(name = "content_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentId;

    @Column(name = "img")
    private String img;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post postId;

    @Builder
    public Content (String img, String description, Post postId) {
        this.img = img;
        this.description = description;
        this.postId = postId;
    }

    public static Content of (WritePostDto.WritePost writePost) {
        return Content
            .builder()
            .description(w)
            .build();

    }
}
