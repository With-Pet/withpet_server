package withpet.server.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import withpet.server.user.entity.User;
import withpet.server.user.entity.dto.SignUpReq;
import withpet.server.user.entity.dto.SignUpRes;
import withpet.server.user.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static withpet.server.user.entity.User.SignUpUser;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public SignUpRes SignUp(SignUpReq signUpReq) {
        User userReq = SignUpUser(signUpReq);
        User save = userRepository.save(userReq);

        SignUpRes res = new SignUpRes();
        res.setUserIdx(save.getUserId());
//        res.setJwt(jwtService.createJwt(save.getUserIdx()));
        return res;
    }

//    public boolean checkNickname(String nickname){
//        return userRepository.existsByNickname(nickname);
//    }


}
