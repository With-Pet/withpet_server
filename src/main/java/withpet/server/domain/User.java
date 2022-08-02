package withpet.server.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import withpet.server.enums.SnsType;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class User extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private SnsType snsType;

    private String nickname;

    private String introduction;

    @Embedded
    private Address address;

    @Embedded
    private Picture picture;


    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @OneToMany(mappedBy = "from")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    private List<Pet> pets;

    @OneToMany(mappedBy = "user")
    private List<Certificate> certificates;

    @OneToMany(mappedBy = "user")
    private List<PostScrap> postScraps;

    @OneToMany(mappedBy = "from")
    private List<UserScrap> userScraps;
}
