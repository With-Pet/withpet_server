package withpet.server.service.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import withpet.server.post.entity.Post;
import withpet.server.user.entity.User;

import javax.persistence.*;
import java.util.Map;

@Getter
@ToString(of = {""})
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long serviceId;         //서비스 고유번호

    @ElementCollection()
    private Map<String,Boolean> service;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;     //유저 정보

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;     //게시물 정보

}
