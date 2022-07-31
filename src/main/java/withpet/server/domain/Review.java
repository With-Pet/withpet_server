package withpet.server.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Review extends BaseEntity{
    @ManyToOne
    private Post post;
    @ManyToOne
    private User from; // 누가
    @ManyToOne
    private User to; // 누구에게
    private String content;
    private int rate;

}
