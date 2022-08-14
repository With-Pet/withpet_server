package withpet.server.count.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import withpet.server.user.entity.User;

import javax.persistence.*;

@Entity
@Getter
@ToString(of = {"countCare", "countExperience", "countWalk"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "count")
public class Count {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long countId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;     //유저 정보정보

    private int countCare; //돌봄 카운트

    private int countExperience; //체험 카운트

    private int countWalk; //산책 카운트
}

