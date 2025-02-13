package com.alkaid.API.base.module.user;

import com.alkaid.API.base.model.Ban;
import com.alkaid.API.base.model.User;
import com.alkaid.API.base.module.body.UserInfoResponse;
import com.alkaid.API.base.repository.BanRepository;
import com.alkaid.API.base.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BanRepository banRepository;


    public UserInfoResponse getUserInfo(String token) {
        Optional<User> user = userRepository.findByToken(token);
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        if (user.isPresent()){
            userInfoResponse.setUsername(user.get().getUsername());
            userInfoResponse.setPassword(user.get().getPassword());
            userInfoResponse.setRank(user.get().getRanks());
            userInfoResponse.setIsBeta(user.get().getIsbeta());
            userInfoResponse.setBanned(isTokenBanned(token));
            userInfoResponse.setIsRegistered(isRegistered(token));
            userInfoResponse.setCapeurl(user.get().getCapeurl());
            userInfoResponse.setSkinurl(user.get().getSkinurl());
            userInfoResponse.setExpirationDate(user.get().getExpiration_date());
        } else {
            userInfoResponse.setIsRegistered(isRegistered(token));
        }
        return userInfoResponse;
    }
    public boolean isTokenBanned(String token) {
        Optional<Ban> optionalBanUser = banRepository.findByToken(token);
        return optionalBanUser.isPresent(); // 如果存在则返回 true，不存在返回 false
    }
    public boolean isRegistered(String token) {
        Optional<User> optionalUser = userRepository.findByToken(token);
        return optionalUser.isPresent(); // 如果存在则返回 true，不存在返回 false
    }
}
