package withpet.server.pet.dto;

import lombok.*;
import withpet.server.pet.entity.Pet;
import withpet.server.pet.entity.enumTypes.PetSex;
import withpet.server.pet.entity.enumTypes.PetType;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetSaveForm {
    private String name;
    private PetType type;
    private String kind;
    private int weight;
    private LocalDate birth;
    private PetSex sex;
    private Boolean isNeutered;
    private String notes;


}
