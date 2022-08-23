package withpet.server.pet.dto;

import org.mapstruct.Mapper;
import withpet.server.pet.dto.PetDetail;
import withpet.server.pet.dto.PetSaveForm;
import withpet.server.pet.entity.Pet;

@Mapper(componentModel = "spring")
public interface PetMapper {
    Pet toPet(PetSaveForm petSaveForm);

    default PetDetail toPetDetail(Pet pet){
        PetDetail detail = PetDetail.builder()
                .petId(pet.getPetId())
                .name(pet.getName())
                .birth(pet.getBirth())
                .isNeutered(pet.getIsNeutered())
                .kind(pet.getKind())
                .notes(pet.getNotes())
                .ownerId(pet.getOwner().getUserId())
                .profile(pet.getPicture().getFileName()) ////
                .sex(pet.getSex())
                .type(pet.getType())
                .weight(pet.getWeight())
                .build();

        return detail;
    }
}
