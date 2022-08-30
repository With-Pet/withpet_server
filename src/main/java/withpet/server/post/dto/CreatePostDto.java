package withpet.server.post.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import withpet.server.location.entity.Location;
import withpet.server.post.entity.enumTypes.ServiceType;
import withpet.server.service.entity.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostDto {
    private List<MultipartFile> pictureList; // 게시글 사진 목록
    private String address; // 동네
    private String title; // 게시글 제목
    private Long petId; // 반려동물
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ServiceType serviceType;
    private List<Service> serviceDetails; // 서비스 상세
    private Long price; // 가격
    private String specifics; // 특이사항
    private String description; // 요청사항
}
