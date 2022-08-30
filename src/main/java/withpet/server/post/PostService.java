package withpet.server.post;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import withpet.server.common.base.BaseRuntimeException;
import withpet.server.pet.PetService;
import withpet.server.pet.entity.Pet;
import withpet.server.pet.repository.PetRepository;
import withpet.server.post.dto.*;
import withpet.server.post.entity.Post;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PetRepository petRepository;
    private PostMapper postMapper;

    @Autowired
    public void setPetMapper(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    // 게시글 등록
    // TODO: 2022-08-30 에러코드 등록
    public void savePost(CreatePostDto createPostDto) {
        try {
            Post post = postMapper.createPostDto2Post(createPostDto);
            postRepository.save(post);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseRuntimeException(null);
        }
    }

    // 게시글 목록 조회
    // TODO: 2022-08-30 에러코드 등록
    // TODO: 2022-08-30 where to convert entity to dto? (service layer or repository) 
    public List<PostDto> getPosts() {
        try {
            // post to postDto
            List<PostDto> posts = postRepository.findAll().stream().map(post -> postMapper.post2PostDto(post)).collect(Collectors.toList());
            return posts;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseRuntimeException(null);
        }
    }

    // 게시글 상세 조회
    // TODO: 2022-08-30 에러코드 등록
    // TODO: 2022-08-30 where to convert entity to dto? (service layer or repository)
    public PostDetailDto getPostDetail(Long id) {
        try {
            // post to postDto
            Post post = postRepository.findById(id).get();
            PostDetailDto postDetail = postMapper.post2PostDetailDto(post);
            return postDetail;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseRuntimeException(null);
        }
    }


    // TODO: 2022-08-30 게시글 수정
    // TODO: 2022-08-30 에러코드 등록
    // TODO: 2022-08-30 setter, save 중복으로 인한 이중 쿼리 날아가지 않는지 확인해보기
    public void updatePost(UpdatePostDto updatePostDto) {
        try {
            Post post = postRepository.findById(updatePostDto.getPostId()).orElseThrow(() -> new BaseRuntimeException(null));

            // delete files
            updatePostDto.getDeletedFile().forEach((file) -> {
                deleteFile(file);
            });

            // upload files
            List<String> pictureUrls = new ArrayList<>();
            updatePostDto.getNewFiles().forEach((file) -> {
                String url = uploadFile(file);
                pictureUrls.add(url);
            });

            // updated post
            Pet pet = petRepository.findById(updatePostDto.getPetId()).orElseThrow(()->new BaseRuntimeException(null));
            Post newPost = postMapper.updatePostDto2Post(post, pet, pictureUrls, updatePostDto);

            // save post
            postRepository.save(newPost);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseRuntimeException(null);
        }
    }

    // 게시글 삭제
    // TODO: 2022-08-30 에러코드 등록
    public void deletePost(Long id) {
        try {
            postRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseRuntimeException(null);
        }
    }

    // TODO: 2022-08-30 파일 업로드 -> 나중에 common으로 빼는 게 좋을 듯 
    public String uploadFile(MultipartFile file) {
        return "[uploaded url in s3]";
    }

    // TODO: 2022-08-30 파일 삭제   -> 同
    void deleteFile(String url) {
        return;
    }
}
