package withpet.server.review;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import withpet.server.common.base.BaseResponse;
import withpet.server.review.dto.ReviewUpdateForm;
import withpet.server.review.dto.ReviewSaveForm;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;


    // 리뷰 등록
    // 8.1
    @PostMapping("/save")
    public BaseResponse saveReview(@RequestPart ReviewSaveForm saveForm){
        reviewService.saveReview(saveForm);
        return new BaseResponse();
    }

    // 리뷰 수정
    // 8.2
    @PostMapping("/update")
    public BaseResponse updateReview(@RequestPart ReviewUpdateForm reviewUpdateForm){
        reviewService.updateReview(reviewUpdateForm);
        return new BaseResponse();
    }

    // 리뷰 삭제
    // 8.3
    // TODO: 2022-08-24 reviewId를 pathVariable로 받을지, RequestBody로 받을지 정하기
    @DeleteMapping("/{id}")
    public BaseResponse deleteReview(@PathVariable Long id){
        reviewService.deleteReview(id);
        return new BaseResponse();
    }

    // 받은 리뷰 조회
    // 8.4
    // TODO: 2022-08-24 사용자 id를 jwt에서 추출하기
    @GetMapping("/received/list")
    public BaseResponse getReceivedReviewList(Long userId){
        List<ReviewUpdateForm> reviews = reviewService.getReceivedReviewList(userId);
        return new BaseResponse(reviews);
    }

    // 작성한 리뷰 조회
    // 8.5
    // TODO: 2022-08-24 사용자 id를 jwt에서 추출하기
    @GetMapping("/sent/list")
    public BaseResponse getSentReviewList(Long userId){
        List<ReviewUpdateForm> reviews = reviewService.getSentReviewList(userId);
        return new BaseResponse(reviews);
    }
}
