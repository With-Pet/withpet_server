package withpet.server.pet.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import withpet.server.common.embeddable.Picture;
import withpet.server.pet.dto.PetDetail;
import withpet.server.pet.dto.PetSaveForm;
import withpet.server.pet.entity.enumTypes.PetSex;
import withpet.server.pet.entity.enumTypes.PetType;
import withpet.server.user.entity.User;

import java.time.LocalDate;

import static org.springframework.test.util.AssertionErrors.assertEquals;


@SpringJUnitConfig(classes = {PetMapperImpl.class})
class PetMapperTest {
    @Autowired
    private PetMapper petMapper;

    @Test
    void toPet_테스트(){
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

    @Test
    void toPetDetail_테스트(){
        //given
        Picture picture = Picture.builder()
                .fileName("profile.jpg")
                .filePath("C:\\User\\Desktop")
                .originFileName("myPet.jpg")
                .build();

        Pet pet = Pet.builder()
                .petId(1L)
                .birth(LocalDate.now())
                .isNeutered(false)
                .kind("시츄")
                .type(PetType.D)
                .name("시츄")
                .notes("없음")
                .picture(picture)
                .owner(new User())
                .build();

        //when
        PetDetail detail = petMapper.toPetDetail(pet);

        //then
        assertEquals("프로필 이미지",detail.getProfile(),pet.getPicture().getFileName());
    }
}