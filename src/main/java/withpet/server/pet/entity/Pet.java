package withpet.server.pet.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import withpet.server.common.embeddable.Picture;
import withpet.server.pet.entity.enumTypes.PetSex;
import withpet.server.pet.entity.enumTypes.PetType;
import withpet.server.post.entity.Post;
import withpet.server.user.entity.CommonDateEntity;
import withpet.server.user.entity.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Pet extends CommonDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long petId;    //펫 고유번호

    @Embedded
    private Picture picture;

    @Column(nullable = false)
    private String name;    //펫 이름

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PetType type;   //펫 종류 D : 강아지, C : 고양이, E : 기타

    @Column(nullable = false)
    private String kind;    //펫 품종

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PetSex sex;     //펫 성별

    @Column(nullable = false)
    private Boolean isNeutered;   //중성화 여부

    @Column(nullable = false)
    private int weight;    //펫 몸무게

    @Column(nullable = false)
    private LocalDate birth;    //펫 생일

    @Column(nullable = false)
    private String notes;   //특이사항 및 참고사항

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;     //보호자 정보

    @JsonManagedReference
    @OneToMany(mappedBy = "pet") //post 에있는 owner 필드에 의해 매핑이 되어 있다.
    @Builder.Default
    private List<Post> posts = new ArrayList<>();

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", picture=" + picture +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", kind='" + kind + '\'' +
                ", sex=" + sex +
                ", isNeutered=" + isNeutered +
                ", weight=" + weight +
                ", birth=" + birth +
                ", notes='" + notes + '\'' +
                ", owner=" + owner +
                ", posts=" + posts +
                '}';
    }
}
