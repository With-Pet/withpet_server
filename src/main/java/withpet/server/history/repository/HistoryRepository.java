package withpet.server.history.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import withpet.server.history.dto.HistoryDto;
import withpet.server.history.entity.History;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    // TODO: 2022-08-24
    //  Post(location, serviceType, starTime(checkIn), endTime(checkOut))
    List<HistoryDto> findByUserId(Long id);
}
