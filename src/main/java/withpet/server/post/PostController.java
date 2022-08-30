package withpet.server.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import withpet.server.common.base.BaseResponse;
import withpet.server.post.dto.PostDetailDto;
import withpet.server.post.dto.PostDto;
import withpet.server.post.dto.CreatePostDto;
import withpet.server.post.dto.UpdatePostDto;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 게시글 등록
    // 5.1
    @PostMapping("/save")
    public BaseResponse savePost(@RequestPart CreatePostDto form) {
        postService.savePost(form);
        return new BaseResponse();
    }

    // 게시글 목록 보기
    // 5.2
    @GetMapping("/list")
    public BaseResponse getPostList() {
        List<PostDto> posts = postService.getPosts();
        return new BaseResponse(posts);
    }

    // 게시글 상세 보기
    // 5.3
    @GetMapping("/{id}")
    public BaseResponse getPostDetail(@PathVariable Long id) {
        PostDetailDto post = postService.getPostDetail(id);
        return new BaseResponse(post);
    }

    // TODO: 2022-08-30 게시글 수정
    // 5.4
    @PutMapping("/update")
    public BaseResponse updatePost(@RequestBody UpdatePostDto updatePostDto) {
        postService.updatePost(updatePostDto);
        return new BaseResponse();
    }

    // TODO: 2022-08-30 게시글 삭제
    @DeleteMapping("/{id}")
    public BaseResponse deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return new BaseResponse();
    }
}
