package withpet.server.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import withpet.server.common.base.BaseRuntimeException;
import withpet.server.post.PostRepository;
import withpet.server.post.entity.Post;
import withpet.server.review.dto.ReviewDto;
import withpet.server.review.dto.UpdateReviewDto;
import withpet.server.review.dto.ReviewMapper;
import withpet.server.review.dto.CreateReviewDto;
import withpet.server.review.entity.Review;
import withpet.server.review.repository.ReviewRepository;
import withpet.server.user.entity.User;
import withpet.server.user.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private ReviewMapper reviewMapper; //


    // TODO: 2022-08-24 Error code 추가하기
    // TODO: 2022-08-31 파일 및 업로드 -> 공통 모듈로 빼내기
    public void saveReview(Long userId, CreateReviewDto saveForm) {
        try {
            User writer = userRepository.findById(userId).orElseThrow(() -> new BaseRuntimeException(null));
            User targetUser = userRepository.findById(saveForm.getTargetUserId()).orElseThrow(() -> new BaseRuntimeException(null));
            Post post = postRepository.findById(saveForm.getPostId()).orElseThrow(() -> new BaseRuntimeException(null));

            // upload files
            List<String> pictureList = new ArrayList<>();
            saveForm.getPictureList().forEach((picture) -> {
            });

            Review review = Review.builder()
                    .pictureList(pictureList)
                    .post(post)
                    .stars(saveForm.getStars())
                    .content(saveForm.getContent())
                    .targetUser(targetUser)
                    .writer(writer)
                    .build();

            reviewRepository.save(review);
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
    public List<ReviewDto> getReceivedReviewList(Long userId) {
        try {
            List<ReviewDto> reviews = reviewRepository.findByTargetUser(userId);
            return reviews;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseRuntimeException(null);
        }
    }

    // TODO: 2022-08-24 Error code 추가하기
    public List<ReviewDto> getSentReviewList(Long userId) {
        try {
            List<ReviewDto> reviews = reviewRepository.findByWriter(userId);
            return reviews;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseRuntimeException(null);
        }
    }

    // TODO: 2022-08-24 Error code 추가하기
    // TODO: 2022-08-24 파일 삭제 및 업로드 -> 공통 모듈로 빼내기
    public void updateReview(UpdateReviewDto updateReviewDto) {
        try {
            Review review = reviewRepository.findById(updateReviewDto.getReviewId()).orElseThrow(() -> new BaseRuntimeException(null));

            List<String> pictureList = new ArrayList<>();
            // upload files
            updateReviewDto.getDeletedFiles().forEach((picture) -> {
            });
            // delete files
            updateReviewDto.getNewFiles().forEach((picture) -> {
            });

            Review newReview = reviewMapper.updateReviewDto2Review(pictureList, review, updateReviewDto);
            reviewRepository.save(newReview);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseRuntimeException(null);
        }
    }
}

