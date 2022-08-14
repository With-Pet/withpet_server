package withpet.server.certificate.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import withpet.server.common.embeddable.Picture;
import withpet.server.user.entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString(of = {"name", "agency", "date"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long certificateId;        //자격증 고유번호

    @Embedded
    private Picture picture;

    @Column(nullable = false)
    private String name;    //자격증 명

    @Column(nullable = false)
    private String agency;  //취득 기관

    @Column(nullable = false)
    private LocalDateTime date; //취득 날짜

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;     //취득자 정보


}
