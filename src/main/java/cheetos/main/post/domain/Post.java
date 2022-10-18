package cheetos.main.post.domain;

import java.time.LocalDateTime;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import cheetos.main.common.BaseTimeEntity;
import cheetos.main.post.enums.LocalCodes;
import cheetos.main.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTimeEntity {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @JoinColumn(name = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;

    @Column(name = "location")
    @Enumerated(EnumType.STRING)
    private LocalCodes location;

    @Column(name = "title")
    private String title;

    @Column(name = "represent_img")
    private String representImg;

    @Column(name = "travel_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime travelDate;
}
