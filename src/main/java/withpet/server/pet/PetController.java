package withpet.server.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import withpet.server.common.base.BaseResponse;
import withpet.server.pet.dto.PetSaveForm;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;


    @PostMapping("/register")
    public BaseResponse register(@RequestBody PetSaveForm petSaveForm){
        petService.registerPet(petSaveForm);
        return new BaseResponse();
    }
}
