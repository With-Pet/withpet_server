package withpet.server.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import withpet.server.pet.entity.enumTypes.PetSex;
import withpet.server.pet.entity.enumTypes.PetType;

@Builder
@AllArgsConstructor
public class PetDetailDto {
    private Long id;
    private String name;
    private PetType type;
    private String kind;
    private int weight;
    private int age;
    private PetSex sex;
    private boolean isNeutered;
}
