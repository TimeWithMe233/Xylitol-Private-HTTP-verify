package com.alkaid.API.base.module.autologin;
import com.alkaid.API.base.model.User;
import com.alkaid.API.base.module.body.LoginInfoResponse;
import com.alkaid.API.base.module.body.UserInfoResponse;
import com.alkaid.API.base.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: DreamDev
 * @Date: 2024/11/2
 * Time:10:25
 */
@Service
public class AutoLoginService {
    @Autowired
    private UserRepository userRepository;

    public LoginInfoResponse autoLogin(String token) {
        Optional<User> user = userRepository.findByToken(token);
        LoginInfoResponse loginInfoResponse = new LoginInfoResponse();
        if (user.isPresent()) {
            loginInfoResponse.setUsername(user.get().getUsername());
            loginInfoResponse.setPassword(user.get().getPassword());
        } else {
            return null;
        }
        return loginInfoResponse;
    }
}
