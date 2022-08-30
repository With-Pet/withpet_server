package withpet.server.post.dto;

import com.sun.xml.bind.v2.TODO;
import org.mapstruct.Mapper;
import withpet.server.pet.entity.Pet;
import withpet.server.post.entity.Post;
import withpet.server.user.entity.User;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    // CreatePostDto -> Post
    Post createPostDto2Post(CreatePostDto form);

    // Post -> PostDto
    default PostDto post2PostDto(Post post) {
        // pet 정보
        Pet pet = post.getPet();
        PetDto petDto = new PetDto(pet.getPetId(), pet.getName(), pet.getType());

        // TODO: 2022-08-30  스크랩 여부
        boolean isScrapped = false;

        return PostDto.builder()
                .pictureUrls(post.getPictureUrls())
                .address(post.getAddress())
                .title(post.getTitle())
                .serviceType(post.getServiceType())
                .pet(petDto)
                .startTime(post.getStartTime())
                .endTime(post.getEndTime())
                .price(post.getPrice())
                .isScrapped(isScrapped).build();
    }

    // Post -> PostDetailDto
    // TODO: 2022-08-30 스크랩 여부
    default PostDetailDto post2PostDetailDto(Post post){
        // pet 정보
        Pet pet = post.getPet();
        PetDetailDto petDto = PetDetailDto.builder().build();

        // 작성자
        User user = post.getUser();
        // TODO: 2022-08-30 User.profile ) Picture -> String
        Writer writer = null;
//        Writer writer = new Writer(user.getUserId(),user.getProfile,user.getNickname());

        // 스크랩 여부
        boolean isScrapped = false;

        return PostDetailDto.builder()
                .pictureUrls(post.getPictureUrls())
                .address(post.getAddress())
                .title(post.getTitle())
                .serviceType(post.getServiceType())
                .pet(petDto)
                .startTime(post.getStartTime())
                .endTime(post.getEndTime())
                .price(post.getPrice())
                .isScrapped(isScrapped)
                .description(post.getDescription())
                .specifics(post.getSpecifics())
                .writer(writer).build();
    }

    // FIXME: 2022-08-30 첨부파일이 수정되지 않은 경우
    default Post updatePostDto2Post(Post post, Pet pet, List<String> pictureUrls, UpdatePostDto updatePostDto){
        // 첨부 파일이 수정되지 않은 경우
        if(updatePostDto.getNewFiles().size() == 0 && updatePostDto.getDeletedFile().size() == 0){
            pictureUrls = post.getPictureUrls();
        }
        return Post.builder()
                .postId(updatePostDto.getPostId())
                .title(updatePostDto.getTitle())
                .startTime(updatePostDto.getStartTime())
                .endTime(updatePostDto.getEndTime())
                .pictureUrls(pictureUrls)
                .serviceType(updatePostDto.getServiceType())
                .price(updatePostDto.getPrice())
                .specifics(updatePostDto.getSpecifics())
                .description(updatePostDto.getDescription())
                .address(updatePostDto.getAddress())
                .x(post.getX())
                .y(post.getY())
                .user(post.getUser())
                .pet(pet)
                .serviceDetails(updatePostDto.getServiceDetails())
                .postFavs(post.getPostFavs())
                .build();
    }
}
