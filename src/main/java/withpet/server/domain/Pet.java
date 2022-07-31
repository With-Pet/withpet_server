package withpet.server.domain;

import withpet.server.enums.PetType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pet extends BaseEntity{
    private String name;
    private PetType petType;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private boolean isNeutered;
    private int weight;
    private LocalDate birthDate;
    private String notes;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;


}
