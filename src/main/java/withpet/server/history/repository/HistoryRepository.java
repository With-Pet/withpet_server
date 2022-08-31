package withpet.server.history.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import withpet.server.history.dto.HistoryDto;
import withpet.server.history.entity.History;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    @Query("select new withpet.server.history.dto.HistoryDto(h.id,h.post.address,h.post.serviceType,h.targetUser.userId,h.targetUser.profile,h.status,h.post.startDate,h.post.endDate) from History as h where h.post.user.userId=:userId")
    List<HistoryDto> findByUserId(Long id);
}
