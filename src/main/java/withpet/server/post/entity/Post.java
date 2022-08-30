package withpet.server.post.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import withpet.server.common.embeddable.Picture;
import withpet.server.pet.entity.Pet;
import withpet.server.post.entity.enumTypes.ServiceType;
import withpet.server.postFav.entity.PostFav;
import withpet.server.service.entity.Service;
import withpet.server.user.entity.CommonDateEntity;
import withpet.server.user.entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "post")
public class Post extends CommonDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long postId;       //게시물 고유 번호

    @Column(nullable = false)
    private String title;   //게시물 제목

    @Column(nullable = false)
    private LocalDateTime startTime;   //시작 날짜

    @Column(nullable = false)
    private LocalDateTime endTime;    //종료 날짜

    @ElementCollection
    private List<String> pictureUrls = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceType serviceType;      //게시물 종류 W : 산책, E : 체험, C : 돌봄

    @Column(nullable = false)
    private Long price;         //시간당 이용 금액

    @Column(nullable = false)
    private String specifics;   //특이사항

    @Column(nullable = false)
    private String description;   //요청 사항

    @Column(nullable = false)
    private String address;    //게시물 지역 명

    @Column(nullable = false)
    private Float x;    //위도

    @Column(nullable = false)
    private Float y;    //경도

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;  //작성자 정보

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;   //펫 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "post")
    private List<Service> serviceDetails = new ArrayList<>();     //이용가능 서비스 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "post")
    private List<PostFav> postFavs = new ArrayList<>();     //게시물 즐겨찾기 정보
}

