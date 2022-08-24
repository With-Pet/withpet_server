package withpet.server.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import withpet.server.common.base.BaseRuntimeException;
import withpet.server.review.dto.ReviewUpdateForm;
import withpet.server.review.dto.ReviewMapper;
import withpet.server.review.dto.ReviewSaveForm;
import withpet.server.review.repository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private ReviewMapper reviewMapper; //


    // TODO: 2022-08-24 Error code 추가하기
    // TODO: 2022-08-24 User 정보 가져오기 -> controller 에서?
    public void saveReview(ReviewSaveForm saveForm) {
        try {
            reviewRepository.save(saveForm);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseRuntimeException(null);
        }
    }

    // TODO: 2022-08-24 Error code 추가하기
    public void deleteReview(Long id) {
        try {
            reviewRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseRuntimeException(null);
        }
    }

    // TODO: 2022-08-24 Error code 추가하기
    public List<ReviewUpdateForm> getReceivedReviewList(Long userId) {
        try {
            List<ReviewUpdateForm> reviews = reviewRepository.findByTargetUser(userId);
            return reviews;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseRuntimeException(null);
        }
    }

    // TODO: 2022-08-24 Error code 추가하기
    public List<ReviewUpdateForm> getSentReviewList(Long userId) {
        try {
            List<ReviewUpdateForm> reviews = reviewRepository.findByWriter(userId);
            return reviews;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseRuntimeException(null);
        }
    }

    // TODO: 2022-08-24 Error code 추가하기
    // TODO: 2022-08-24 리뷰 수정 로직 작성하기 
    public void updateReview(ReviewUpdateForm reviewUpdateForm) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseRuntimeException(null);
        }
    }
}

