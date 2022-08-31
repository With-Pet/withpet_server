package withpet.server.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateReviewDto {
    private Long postId;
    private int stars;
    private String content;
    private List<MultipartFile> pictureList;
    private Long targetUserId;
}
