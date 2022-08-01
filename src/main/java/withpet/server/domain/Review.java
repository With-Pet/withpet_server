package withpet.server.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Review extends BaseEntity{
    @ElementCollection
    private List<Picture> pictureList = new ArrayList<>();

    @ManyToOne
    private Post post;

    @ManyToOne
    private User from; // 누가

    @ManyToOne
    private User to; // 누구에게

    private String content;

    private int rate;

}
