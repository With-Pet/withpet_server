package withpet.server.domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class ServiceDetail extends BaseEntity{
    private String name;
}
