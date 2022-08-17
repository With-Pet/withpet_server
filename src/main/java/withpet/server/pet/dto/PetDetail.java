package withpet.server.pet.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import withpet.server.common.embeddable.Picture;
import withpet.server.pet.entity.enumTypes.PetSex;
import withpet.server.pet.entity.enumTypes.PetType;
import withpet.server.post.entity.Post;
import withpet.server.user.entity.CommonDateEntity;
import withpet.server.user.entity.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PetDetail {
    private Long petId;     //펫 고유번호
    private String name;    //펫 이름
    private PetType type;   //펫 종류 D : 강아지, C : 고양이, E : 기타
    private String kind;    //펫 품종
    private PetSex sex;     //펫 성별
    private Boolean isNeutered;   //중성화 여부
    private int weight;     //펫 몸무게
    private LocalDate birth;//펫 생일
    private String notes;   //특이사항 및 참고사항
    private Long ownerId;   //보호자 정보
    private String profile; //프로필 사진 정보
}
