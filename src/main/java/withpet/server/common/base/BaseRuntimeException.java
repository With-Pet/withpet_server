package withpet.server.common.base;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseRuntimeException extends RuntimeException{
    private BaseResponseStatus status;
}
