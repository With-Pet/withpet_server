package withpet.server.review.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import withpet.server.post.entity.enumTypes.ServiceType;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private Long reviewId;
//    private LocalDateTime createdAt;
    private ServiceType serviceType;
    private LocalDateTime startDate;
    private Long price;
    private String content;
    private int stars;
    private List<String> pictureList;
}
