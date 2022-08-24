package withpet.server.post.dto;

import withpet.server.location.entity.Location;
import withpet.server.post.entity.enumTypes.ServiceType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class PostDto {
    // TODO: 2022-08-24 profile을 url로 줄 것인지, 파일로 줄 것인지 정하기
    // private File picture; // private String pictureUrl; // 게시글 대표 사진

    private Location location; // 동네
    private String title; // 제목
    private ServiceType serviceType; // 서비스 종류
    private List<PetDto> pets; // 펫 종류
    private LocalDateTime startTime; // 시작 시간
    private LocalDateTime endTime; // 종료 시간
    private Long price; // 보상
    private boolean isScrapped; // 즐겨찾기 여부

}
