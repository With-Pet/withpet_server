package withpet.server.domain;

import lombok.Builder;
import withpet.server.enums.ServiceType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Post extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;
//    @ElementCollection
//    @Builder.Default
//    private Map<ServiceDetail> serviceDetails = new HashMap();

    private LocalDate startTime;
    private LocalDate endTime;

    private int price;
    private String specifics;
    private String description;

    @ManyToOne
    private Pet pet;
    @ManyToOne
    private User user;

}
