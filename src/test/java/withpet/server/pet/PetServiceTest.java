package withpet.server.pet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import withpet.server.common.base.BaseRuntimeException;
import withpet.server.common.embeddable.Picture;
import withpet.server.pet.dto.PetDetail;
import withpet.server.pet.dto.PetSaveForm;
import withpet.server.pet.entity.Pet;
import withpet.server.pet.entity.PetMapper;
import withpet.server.pet.entity.PetMapperImpl;
import withpet.server.pet.entity.enumTypes.PetSex;
import withpet.server.pet.entity.enumTypes.PetType;
import withpet.server.pet.repository.PetRepository;
import withpet.server.user.entity.User;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {
    ////////////////////////////////////
    @Mock
    private PetRepository petRepository;
//    @Mock
    private PetMapper petMapper = Mappers.getMapper(PetMapper.class);

    @InjectMocks
    private PetService petService;

    ////////////////////////////////////
    private PetSaveForm petSaveForm = PetSaveForm.builder()
            .birth(LocalDate.now())
            .isNeutered(Boolean.FALSE)
            .sex(PetSex.FEMALE)
            .kind("골든리트리버")
            .type(PetType.D)
            .name("초코")
            .weight(11)
            .build();

    private Picture picture = Picture.builder()
            .fileName("profile.jpg")
            .filePath("C:\\User\\Desktop")
            .originFileName("myPet.jpg")
            .build();

    private Pet pet = Pet.builder()
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

    ////////////////////////////////////

    @BeforeEach
    void setMapper(){
        petService.setPetMapper(petMapper);
    }
    @Test
    void 펫_등록_성공(){
        //given

        //when
        petService.registerPet(petSaveForm);

        //then
        //nothing
    }

    @Test
    void 펫_등록_실패(){
        //given
        when(petRepository.save(any())).thenThrow(RuntimeException.class);

        //when

        //then
        assertThrows(BaseRuntimeException.class,()->petService.registerPet(petSaveForm));
    }

    @Test
    void 펫_조회_성공(){
        //given
        when(petRepository.findById(anyLong())).thenReturn(Optional.of(pet));

        //when
        PetDetail detail = petService.getPet(1L);

        //then
        assertNotNull(detail);
    }

    @Test
    void 펫_조회_실패(){
        //given
        when(petRepository.findById(any())).thenThrow(IllegalArgumentException.class);

        //when

        //then
        assertThrows(BaseRuntimeException.class,()->petService.getPet(1L));
    }
}