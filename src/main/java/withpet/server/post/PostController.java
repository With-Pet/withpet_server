package withpet.server.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import withpet.server.common.base.BaseResponse;
import withpet.server.post.dto.PostDetailDto;
import withpet.server.post.dto.PostDto;
import withpet.server.post.dto.PostSaveForm;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    // TODO: 2022-08-24 게시글 등록
    // 5.1
    @PostMapping("/save")
    public BaseResponse savePost(@RequestPart PostSaveForm form){
        postService.savePost(form);
        return new BaseResponse();
    }

    // TODO: 2022-08-24  게시글 목록 보기
    // 5.2
    @GetMapping("/list")
    public BaseResponse getPostList(){
        List<PostDto>  posts = postService.getPosts();
        return new BaseResponse(posts);
    }

    // TODO: 2022-08-24 게시글 상세 보기
    // 5.3
    @GetMapping("/{id}")
    public BaseResponse getPostDetail(@PathVariable Long id){
        PostDetailDto post = postService.getPostDetail(id);
        return new BaseResponse(post);
    }
}
