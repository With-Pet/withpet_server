package withpet.server.review.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateReviewDto {
    private Long reviewId;
    private List<String> deletedFiles;
    private List<MultipartFile> newFiles;
    private int stars;
    private String content;
}
