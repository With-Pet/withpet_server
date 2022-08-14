package withpet.server.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import withpet.server.common.base.BaseException;
import withpet.server.common.base.BaseResponse;
import withpet.server.common.base.BaseResponseStatus;
import withpet.server.user.entity.dto.SignUpReq;
import withpet.server.user.entity.dto.SignUpRes;
import withpet.server.utils.ValidationExceptionProvider;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;
//    private JwtService jwtService;

    @PostMapping("/sign-up")
    @ResponseBody
    public BaseResponse<SignUpRes> SingUp(@RequestBody @Valid SignUpReq signUpReq, Errors errors) {
        if (errors.hasErrors()) {
            BaseException exception = ValidationExceptionProvider.throwValidError(errors);
            return new BaseResponse<>(exception.getStatus());
        } else {
            SignUpRes signUpRes = userService.SignUp(signUpReq);
            return new BaseResponse<>(signUpRes);
        }
    }

//    @PostMapping("/nickname")
//    @ResponseBody
//    public BaseResponse<String> checkNickname(@RequestBody @Valid PostNickname postNickname,Errors errors){
//        if(errors.hasErrors()){
//            BaseException exception= ValidationExceptionProvider.throwValidError(errors);
//            return new BaseResponse<>(exception.getStatus());
//        }else if(userService.checkNickname(postNickname.getNickname())){
//            return new BaseResponse<>(BaseResponseStatus.DUPLICATE_NICKNAME);
//        }else{
//            return new BaseResponse<>("사용 가능한 닉네임입니다.");
//        }
//    }

}
