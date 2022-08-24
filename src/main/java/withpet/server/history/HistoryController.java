package withpet.server.history;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import withpet.server.common.base.BaseResponse;
import withpet.server.history.dto.HistoryDto;
import withpet.server.history.entity.History;

import java.util.List;

@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryService historyService;
    
    // 이력 목록 반환
    // 7.1
    // TODO: 2022-08-24 parameter 변경(사용자 id -> jwt에서 추출해야 함) 
    @GetMapping("/list")
    public BaseResponse getHistoryList(Long id){
        List<HistoryDto> historyList = historyService.getHistoryList(id);
        return new BaseResponse(historyList);
    }

    //이용 상태 변경1 (before -> reserved)
    // 7.2
    @PostMapping("/reserve")
    public BaseResponse reserve(@RequestBody Long historyId, @RequestBody Long targetUserId){
        historyService.updateStatusToReserved(historyId,targetUserId);
        return new BaseResponse();
    }

    //이용 상태 변경1 (reserved->check in)
    // 7.3
    @PostMapping("/checkIn")
    public BaseResponse checkIn(@RequestBody Long historyId, @RequestBody Long targetUserId){
        historyService.updateStatusToCheckIn(historyId,targetUserId);
        return new BaseResponse();
    }

    //이용 상태 변경1 (check in -> check out)
    // 7.2
    @PostMapping("/checkOut")
    public BaseResponse checkOut(@RequestBody Long historyId, @RequestBody Long targetUserId){
        historyService.updateStatusToCheckOut(historyId,targetUserId);
        return new BaseResponse();
    }
}
