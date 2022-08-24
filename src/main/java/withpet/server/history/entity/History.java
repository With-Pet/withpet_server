package withpet.server.history.entity;

import lombok.Setter;
import withpet.server.history.entity.enumTypes.Status;
import withpet.server.pet.entity.Pet;
import withpet.server.post.entity.Post;
import withpet.server.user.entity.User;

import javax.persistence.*;

@Entity
@Setter
public class History {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private Post post;
    @ManyToOne
    private Pet pet;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private User targetUser; // 서비스 제공자
}
