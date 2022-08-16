package withpet.server.common.base;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Runtime Exception
    @ExceptionHandler(BaseRuntimeException.class)
    public BaseResponse handleRuntimeException(BaseRuntimeException e){
        BaseResponseStatus status=e.getStatus();
        return new BaseResponse(status);
    }

    // Exception
    @ExceptionHandler(BaseException.class)
    public BaseResponse handleException(BaseException e){
        BaseResponseStatus status=e.getStatus();
        return new BaseResponse(status);
    }
}
