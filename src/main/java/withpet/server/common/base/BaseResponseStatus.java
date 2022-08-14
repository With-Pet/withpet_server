package withpet.server.common.base;

import lombok.Getter;

/**
 * 에러 코드 관리
 */

@Getter
public enum BaseResponseStatus {
    /**
     * 200: 요청 성공
     */
    SUCCESS(true,200,"요청에 성공하였습니다."),

    /**
     * 400: REQUEST 오류
     */
    DATABASE_ERROR(false,401,"데이터베이스 오류입니다."),
    EMPTY_NICKNAME(false,402,"닉네임을 입력해주세요."),
    POST_INVALID_NICKNAME(false,403,"닉네임 형식이 올바르지 않습니다"),
    DUPLICATE_NICKNAME(false,404,"중복된 닉네임입니다"),
    JOIN_USER(false,405,"회원가입을 진행해주세요"),

    /**
     * 500: RESPONSE 오류
     */
    RESPONSE_ERROR(false,500,"값을 불러오는데 실패했습니다.");



    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
