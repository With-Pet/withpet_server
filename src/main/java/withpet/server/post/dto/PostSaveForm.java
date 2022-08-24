package withpet.server.post.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import withpet.server.location.entity.Location;
import withpet.server.post.entity.enumTypes.ServiceType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class PostSaveForm {
    private List<MultipartFile> pictureList; // 게시글 사진 목록
    private Location location; // 동네
    private String title; // 게시글 제목
    private List<Long> petList; // 반려동물 목록(아이디)
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ServiceType serviceType;
    private Map<String,Boolean> serviceDetails; // 서비스 상세
    private Long price; // 가격
    private String specifics; // 특이사항
    private String description; // 요청사항
}
