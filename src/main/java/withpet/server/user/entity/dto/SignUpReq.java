package withpet.server.user.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import withpet.server.common.embeddable.Address;
import withpet.server.user.entity.enumTypes.SnsType;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpReq {

    @NotEmpty(message = "닉네임을 입력해주세요")
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-zA-Z0-9-_]{1,10}$",message = "닉네임은 특수 문자를 제외한 10자리 이내로 입력해주세요")
    private String nickname;

    @NotNull(message = "소셜 로그인 타입을 입력해주세요")
    private SnsType snsType;

    @NotNull(message = "엑세스 토큰을 입력해주세요")
    private String aToken;

//    @NotBlank(message = "회원 아이디를 입력해 주세요")
//    private String snsId;

    @NotNull(message = "주소를 입력해주세요")
    private Address address;


}
