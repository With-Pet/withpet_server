package withpet.server.post.dto;

import org.mapstruct.Mapper;
import withpet.server.post.entity.Post;

@Mapper(componentModel = "spring")
public interface PostMapper {
    // TODO: 2022-08-24 매핑 잘 되는지 확인!(es, pictureList) 
//    Post formToPost(PostSaveForm form);
}
