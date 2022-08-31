package withpet.server.user.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import withpet.server.certificate.entity.Certificate;
import withpet.server.common.embeddable.Address;
import withpet.server.count.entity.Count;
import withpet.server.pet.entity.Pet;
import withpet.server.post.entity.Post;
import withpet.server.postFav.entity.PostFav;
import withpet.server.review.entity.Review;
import withpet.server.service.entity.Service;
import withpet.server.user.entity.dto.SignUpReq;
import withpet.server.user.entity.enumTypes.SnsType;
import withpet.server.userFav.entity.UserFav;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString(of = {"userId", "snsId", "nickname", "snsType", "address", "x", "y", "countWalk", "countCaring", "countExperience", "introduction", "fcmToken"})
@Table(name = "user")
public class User extends CommonDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long userId;      //회원 고유번호

    @Column(nullable = false)
    private SnsType snsType;  //가입한 SNS 종류

    @Column(nullable = false)
    private String nickname;  //닉네임

    @Column(nullable = false, unique = true)
    private String snsId;     //회원 아이디, 모두 SNS 계정 이므로 ID = EMAIL

    private String profile;

    @Column(nullable = false)
    private Address address;  //회원 주소

    private Float x;        //경도

    private Float y;        //위도

    private Integer countWalk;  //산책 카운트

    private Integer countCaring; //돌봄 카운트

    private Integer countExperience; //체험99*-`0 카운트

    private String introduction;    //유저 자기소개

    private String fcmToken;    //FCM 토큰 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "user")   //post 에있는 user 필드에 의해 매핑이 되어 있다.
    private List<Post> posts = new ArrayList<>();   //회원이 작성한 게시글

    @JsonManagedReference
    @OneToMany(mappedBy = "owner")  //pet 에있는 owner 필드에 의해 매핑이 되어 있다.
    private List<Pet> pets = new ArrayList<>();     //회원 소유 펫

    @JsonManagedReference
    @OneToMany(mappedBy = "user")  //certificate 에있는 user 필드에 의해 매핑이 되어 있다.
    private List<Certificate> certificates = new ArrayList<>();    //회원 소유 자격증

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Service> services = new ArrayList<>();     //회원 이용가능 서비스

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();     //회원이 작성한 리뷰

    @JsonManagedReference
    @OneToMany(mappedBy = "targetUser")
    private List<Review> targetReviews = new ArrayList<>();     //회원이 받은 리뷰

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<PostFav> postFavs = new ArrayList<>();     //게시물 즐겨찾기 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<UserFav> userFavs = new ArrayList<>();     //좋아요한 유저 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<UserFav> favUsers = new ArrayList<>();     //회원이 좋아요한 유저 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "targetUser")
    private List<UserFav> favTargetUsers = new ArrayList<>();     //회원을 좋아한 유저 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Count> counts = new ArrayList<>();     //돌봄, 체험, 산책 카운트 정보

    public static User SignUpUser(SignUpReq signUpReq){
        return User.builder()
                .nickname(signUpReq.getNickname())
                .snsType(signUpReq.getSnsType())
                .address(signUpReq.getAddress())
                .build();
    }
}
