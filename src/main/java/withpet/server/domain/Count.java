package withpet.server.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Count extends BaseEntity{
    @ManyToOne
    private User user;
    private int countCare;
    private int countExperience;
    private int countWalk;
}
