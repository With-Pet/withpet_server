package withpet.server.pet;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import withpet.server.common.base.BaseResponseStatus;

import withpet.server.common.base.BaseRuntimeException;
import withpet.server.pet.entity.PetMapper;
import withpet.server.pet.dto.PetSaveForm;
import withpet.server.pet.repository.PetRepository;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;
    private final PetMapper petMapper;

    // TODO: 2022-08-16 pet 프로필 사진 업로드
    public void registerPet(PetSaveForm petSaveForm) {
        try {
            // 펫 기본정보 등록
            petRepository.save(petMapper.toPet(petSaveForm));

            // 펫 사진 업로드
            upload();
        }catch (Exception e){
            throw new BaseRuntimeException(BaseResponseStatus.FAIL_REGISTER_PET);
        }
    }

    // TODO: 2022-08-16 pet 프로필 사진 업로드
    private void upload(){
        System.out.println("업로드됨");
    }
}
