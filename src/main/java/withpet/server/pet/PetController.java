package withpet.server.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import withpet.server.common.base.BaseResponse;
import withpet.server.pet.dto.PetDetail;
import withpet.server.pet.dto.PetSaveForm;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;

    // 펫 등록(2.1)
    // TODO: 2022-08-16 validation 추가
    @PostMapping("/register")
    public BaseResponse register(@RequestBody PetSaveForm petSaveForm){
        petService.registerPet(petSaveForm);
        return new BaseResponse();
    }

    // 펫 수정(2.2)
    // TODO: 2022-08-16 validation 추가
    // TODO: 2022-08-23 parameter 변경 -> 각 필드의 수정 여부 포함하도록
    @PostMapping("/update")
    public BaseResponse update(@RequestParam Long id, @RequestBody PetSaveForm petSaveForm){
        return new BaseResponse();
    }

    // 펫 삭제(2.3)
    @PostMapping("/delete/{id}")
    public BaseResponse delete(@PathVariable Long id){
        petService.delete(id);
        return new BaseResponse();
    }


    // 펫 상세 조회(2.5)
    @GetMapping("/{id}")
    public BaseResponse getPet(@PathVariable Long id){
        PetDetail pet = petService.getPet(id);
        return new BaseResponse(pet);
    }
}
