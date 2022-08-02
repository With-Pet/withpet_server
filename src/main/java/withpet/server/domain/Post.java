package withpet.server.domain;

import lombok.Builder;
import withpet.server.enums.ServiceType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Post extends BaseEntity{

    @ElementCollection
    private List<Picture> pictureList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @ManyToMany
    private Set<ServiceDetail> serviceDetails = new HashSet<>();

    private LocalDate startTime;
    private LocalDate endTime;

    private int price;
    private String specifics;
    private String description;

    @ManyToOne
    private Pet pet;
    @ManyToOne
    private User user;

    @Embedded
    private Address address;
}
