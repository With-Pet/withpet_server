package withpet.server.history;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import withpet.server.common.base.BaseResponseStatus;
import withpet.server.common.base.BaseRuntimeException;
import withpet.server.history.dto.HistoryDto;
import withpet.server.history.entity.History;
import withpet.server.history.entity.enumTypes.Status;
import withpet.server.history.repository.HistoryRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;

    // 이력 (게시글 등록 이력) 조회하기
    // TODO: 2022-08-24 Error 코드 등록하기
    public List<HistoryDto> getHistoryList(Long id) {
        try{
            return historyRepository.findByUserId(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new BaseRuntimeException(null);
        }
    }


    // 서비스 이용 상태 변경하기 : BEFORE -> RESERVED
    // TODO: 2022-08-24 Error 코드 등록하기
    public void updateStatusToReserved(Long historyId, Long targetUserId) {
        try{
            History history = historyRepository.findById(historyId).get();
            history.setStatus(Status.RESERVED);
        }catch (Exception e){
            e.printStackTrace();
            throw new BaseRuntimeException(null);
        }
    }


    // 서비스 이용 상태 변경하기 : RESERVED -> CHECK_IN
    // TODO: 2022-08-24 Error 코드 등록하기
    public void updateStatusToCheckIn(Long historyId, Long targetUserId) {
        try{
            History history = historyRepository.findById(historyId).get();
            history.setStatus(Status.CHECK_IN);
        }catch (Exception e){
            e.printStackTrace();
            throw new BaseRuntimeException(null);
        }
    }

    // 서비스 이용 상태 변경하기 : CHECK_IN -> CHECK_OUT
    // TODO: 2022-08-24 Error 코드 등록하기
    public void updateStatusToCheckOut(Long historyId, Long targetUserId) {
        try{
            History history = historyRepository.findById(historyId).get();
            history.setStatus(Status.CHECK_OUT);
        }catch (Exception e){
            e.printStackTrace();
            throw new BaseRuntimeException(null);
        }
    }

}
