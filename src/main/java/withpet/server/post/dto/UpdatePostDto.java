package withpet.server.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import withpet.server.post.entity.enumTypes.ServiceType;
import withpet.server.service.entity.Service;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePostDto {
    private Long postId;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<String> deletedFile; // 삭제할 파일들의 url
    private List<MultipartFile> newFiles; // 새로 등록할 파일들
    private ServiceType serviceType;
    private Long price;
    private String specifics;
    private String description;
    private String address;
    private Long petId;
    private List<Service> serviceDetails;
}
