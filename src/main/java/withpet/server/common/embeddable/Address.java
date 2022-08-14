package withpet.server.common.embeddable;

import javax.persistence.Embeddable;


@Embeddable
public class Address {
    // kakao local api를 기준으로 작성하였습니다.
    private String region1DepthName; // 시도 단위
    private String region2DepthName; // 구 단위
    private String region3DepthName; // 동 단위(행정동 or 법정동)
}
