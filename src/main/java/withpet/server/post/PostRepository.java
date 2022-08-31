package withpet.server.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import withpet.server.post.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
