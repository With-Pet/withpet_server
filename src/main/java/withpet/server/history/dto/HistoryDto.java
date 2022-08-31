package withpet.server.history.dto;

import lombok.AllArgsConstructor;
import withpet.server.history.entity.enumTypes.Status;
import withpet.server.location.entity.Location;
import withpet.server.post.entity.enumTypes.ServiceType;

import java.time.LocalDateTime;

@AllArgsConstructor
public class HistoryDto {
    private Long historyId;
    private String address;
    private ServiceType serviceType;

    // 서비스 제공자
    private Long targetUserId;
    private String targetUserProfile;

    private Status status;
    private LocalDateTime checkIn; // startTime
    private LocalDateTime checkOut; // endTime

}
