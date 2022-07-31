package withpet.server.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class UserScrap extends BaseEntity{
    @ManyToOne
    private User from;
    @ManyToOne
    private User to;
}
