package withpet.server.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PostScrap extends BaseEntity{
    @ManyToOne
    private Post post;
    @ManyToOne
    private User user;
}
