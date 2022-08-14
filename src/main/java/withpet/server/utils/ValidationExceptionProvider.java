package withpet.server.utils;

import org.springframework.validation.Errors;
import withpet.server.common.base.BaseException;
import withpet.server.common.base.BaseResponseStatus;

public class ValidationExceptionProvider {

    public static BaseException throwValidError(Errors errors){
        String errorCode=errors.getFieldError().getCode();
        String errorTarget=errors.getFieldError().getField();
        return new BaseException(ValidationExceptionProvider.getExceptionStatus(errorCode,errorTarget));
    }

    public static BaseResponseStatus getExceptionStatus(String code, String target){
        if(code.equals("NotEmpty")){
            if(target.equals("nickname")) return BaseResponseStatus.EMPTY_NICKNAME;
        }else if(code.equals("Pattern")){
            if(target.equals("nickname")) return BaseResponseStatus.POST_INVALID_NICKNAME;
        }
        return BaseResponseStatus.RESPONSE_ERROR;
    }
}
