package withpet.server.pet.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import withpet.server.pet.dto.PetSaveForm;
import withpet.server.pet.entity.enumTypes.PetSex;
import withpet.server.pet.entity.enumTypes.PetType;

import java.time.LocalDate;

@SpringJUnitConfig(classes = {PetMapperImpl.class})
class PetMapperTest {
    @Autowired
    private PetMapper petMapper;

    @Test
    void mapStruct_테스트(){
        //given
        PetSaveForm saveForm = PetSaveForm.builder()
                .birth(LocalDate.now())
                .isNeutered(Boolean.FALSE)
                .type(PetType.D)
                .kind("골든리트리버")
                .name("초코")
                .sex(PetSex.MALE)
                .notes("귀가 안좋아요")
                .build();

        //when
        Pet pet = petMapper.toPet(saveForm);

        //then
        System.out.println(pet.toString());
    }


}