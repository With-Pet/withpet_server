package withpet.server.post;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import withpet.server.pet.dto.PetMapper;
import withpet.server.post.dto.PostDetailDto;
import withpet.server.post.dto.PostDto;
import withpet.server.post.dto.PostMapper;
import withpet.server.post.dto.PostSaveForm;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private PostMapper postMapper;

    @Autowired
    public void setPetMapper(PostMapper postMapper){
        this.postMapper=postMapper;
    }

    // 게시글 등록
    public void savePost(PostSaveForm form) {

    }

    // 게시글 목록 조회
    public List<PostDto> getPosts() {
        return null;
    }

    // 게시글 상세 조회
    public PostDetailDto getPostDetail(Long id) {
        return null;
    }

}
