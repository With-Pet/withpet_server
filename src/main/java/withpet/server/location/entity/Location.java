package withpet.server.location.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import withpet.server.pet.entity.enumTypes.PetSex;
import withpet.server.pet.entity.enumTypes.PetType;
import withpet.server.post.entity.Post;
import withpet.server.user.entity.CommonDateEntity;
import withpet.server.user.entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString(of = {"locationId", "city", "district", "dong"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "location")
public class Location extends CommonDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long locationId;    //지역 고유번호

    @Column(nullable = false)
    private String city;        //시

    @Column(nullable = false)
    private String district;    //구

    @Column(nullable = false)
    private String dong;        //동


}
