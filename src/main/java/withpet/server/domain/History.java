package withpet.server.domain;

import withpet.server.enums.Status;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
public class History extends BaseEntity{
    @ManyToOne
    private Post post;
    @ManyToOne
    private Pet pet;
    @Enumerated(EnumType.STRING)
    private Status status;
}
