package withpet.server.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import withpet.server.location.entity.Location;
import withpet.server.pet.dto.PetDetail;
import withpet.server.post.entity.enumTypes.ServiceType;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PostDetailDto {
    private List<String> pictureUrls; // 첨부파일(사진)의 url in s3
    private String address; // 동네
    private String title; // 제목
    private ServiceType serviceType; // 서비스 종류
    private PetDetailDto pet; // 펫 종류
    private LocalDateTime startTime; // 시작 시간
    private LocalDateTime endTime; // 종료 시간
    private Long price; // 보상
    private boolean isScrapped; // 즐겨찾기 여부
    private String specifics;
    private String description;
    private Writer writer;
}
