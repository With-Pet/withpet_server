package withpet.server.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Certificate extends BaseEntity{
    @Embedded
    private Picture picture;

    private String agency;
    private String name;
    private LocalDate acquiredAt;
    @ManyToOne
    private User user;
}
