package withpet.server.review.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import withpet.server.common.embeddable.Picture;
import withpet.server.post.entity.Post;
import withpet.server.user.entity.CommonDateEntity;
import withpet.server.user.entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString(of = {"reviewId", "content"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "certificate")
public class Review extends CommonDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long reviewId;  //리뷰 고유번호

    @ElementCollection
    private List<Picture> pictureList = new ArrayList<>();

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;     //게시물 정보

    @Column(nullable = false)
    private int stars;  //리뷰 별점

    @Column(nullable = false)
    private String content; //리뷰 내용

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User targetUser;     //타겟 유저 정보

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User writer;     //작성자 정보

}