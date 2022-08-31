package withpet.server.review.dto;

import org.mapstruct.Mapper;
import withpet.server.post.entity.Post;
import withpet.server.review.entity.Review;
import withpet.server.user.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    default Review updateReviewDto2Review(List<String> pictureList, Review review, UpdateReviewDto updateReviewDto){
        return Review.builder()
                .reviewId(updateReviewDto.getReviewId())
                .pictureList(pictureList)
                .content(updateReviewDto.getContent())
                .post(review.getPost())
                .writer(review.getWriter())
                .stars(updateReviewDto.getStars())
                .targetUser(review.getTargetUser())
                .build();
    }
}
