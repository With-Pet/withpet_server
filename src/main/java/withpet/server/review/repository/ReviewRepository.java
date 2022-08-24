package withpet.server.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import withpet.server.review.dto.ReviewUpdateForm;
import withpet.server.review.dto.ReviewSaveForm;
import withpet.server.review.entity.Review;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    // TODO: 2022-08-24  
    @Query("")
    public void save(ReviewSaveForm reviewSaveForm);


    // TODO: 2022-08-24  
    List<ReviewUpdateForm> findByTargetUser(Long userId);

    // TODO: 2022-08-24  
    List<ReviewUpdateForm> findByWriter(Long userId);
}
