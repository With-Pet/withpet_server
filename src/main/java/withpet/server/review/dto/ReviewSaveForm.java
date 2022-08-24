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
public class ReviewSaveForm {
    private Long postId;
    private int stars;
    private String comments;
    private List<MultipartFile> pictureList;
}
