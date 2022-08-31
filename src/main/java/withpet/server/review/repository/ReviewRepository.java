package withpet.server.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import withpet.server.review.dto.ReviewDto;
import withpet.server.review.dto.UpdateReviewDto;
import withpet.server.review.dto.CreateReviewDto;
import withpet.server.review.entity.Review;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    @Query("select new withpet.server.review.dto.ReviewDto" +
            "(r.reviewId, r.post.serviceType, r.post.startDate, r.post.price, r.content, r.stars, r.pictureList) from Review as r where r.targetUser.userId=:userId")
    List<ReviewDto> findByTargetUser(Long userId);

    @Query("select new withpet.server.review.dto.ReviewDto" +
            "(r.reviewId, r.post.serviceType, r.post.startDate, r.post.price, r.content, r.stars, r.pictureList) from Review as r where r.writer.userId=:userId")
    List<ReviewDto> findByWriter(Long userId);
}
