package withpet.server.pet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import withpet.server.common.base.BaseException;
import withpet.server.common.base.BaseRuntimeException;
import withpet.server.pet.dto.PetSaveForm;
import withpet.server.pet.entity.Pet;
import withpet.server.pet.entity.PetMapper;
import withpet.server.pet.entity.enumTypes.PetSex;
import withpet.server.pet.entity.enumTypes.PetType;
import withpet.server.pet.repository.PetRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {
    ////////////////////////////////////
    @Mock
    private PetRepository petRepository;
    @Mock
    private PetMapper petMapper;

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

    private Pet pet = Pet.builder().build();
    ////////////////////////////////////

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
}