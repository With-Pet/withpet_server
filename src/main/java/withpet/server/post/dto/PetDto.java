package withpet.server.post.dto;


import lombok.AllArgsConstructor;
import withpet.server.pet.entity.enumTypes.PetType;

@AllArgsConstructor
public class PetDto {
    private Long id;
    private String name;
    private PetType type;
}
