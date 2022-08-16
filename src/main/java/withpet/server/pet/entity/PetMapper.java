package withpet.server.pet.entity;

import org.mapstruct.Mapper;
import withpet.server.pet.dto.PetSaveForm;

@Mapper(componentModel = "spring")
public interface PetMapper {
    Pet toPet(PetSaveForm petSaveForm);
}
