package withpet.server.pet;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import withpet.server.common.base.BaseResponseStatus;

import withpet.server.common.base.BaseRuntimeException;
import withpet.server.pet.dto.PetDetail;
import withpet.server.pet.dto.PetSaveForm;
import withpet.server.pet.entity.Pet;
import withpet.server.pet.dto.PetMapper;
import withpet.server.pet.repository.PetRepository;

import javax.transaction.Transactional;

@Data
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;
    // 테스트 코드 실행할 때는 final 키워드 지우기 -> petMapper 직접 setting
    private PetMapper petMapper;

    @Autowired
    public void setPetMapper(PetMapper petMapper){
        this.petMapper=petMapper;
    }

    // TODO: 2022-08-16 pet 프로필 사진 업로드
    public void registerPet(PetSaveForm petSaveForm) {
        try {
            Pet pet = petMapper.toPet(petSaveForm);

            // 펫 기본정보 등록
            petRepository.save(pet);

            // 펫 사진 업로드
            upload();
        }catch (Exception e){
            e.printStackTrace();
            throw new BaseRuntimeException(BaseResponseStatus.FAIL_REGISTER);
        }
    }

    // TODO: 2022-08-16 pet 프로필 사진 업로드
    private void upload(){
        System.out.println("업로드됨");
    }


    // 펫 상세 조회
    public PetDetail getPet(Long id) {
        try {
            Pet pet = petRepository.findById(id).get();
            PetDetail detail = petMapper.toPetDetail(pet);

            return detail;
        }catch (Exception e){
//            e.printStackTrace();
            throw new BaseRuntimeException(BaseResponseStatus.FAIL_FIND);
        }
    }

    public void updatePet(Long id, PetSaveForm petSaveForm) {
        try {

        }catch (Exception e){
            e.printStackTrace();
            throw new BaseRuntimeException(BaseResponseStatus.FAIL_REGISTER);
        }
    }
}
