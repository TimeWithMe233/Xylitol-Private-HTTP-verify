package com.alkaid.API.base.module.login;

import com.alkaid.API.base.json.JsonRequest;
import com.alkaid.API.base.model.Ban;
import com.alkaid.API.base.model.User;
import com.alkaid.API.base.repository.BanRepository;
import com.alkaid.API.base.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private BanRepository banRepository;

    public int login(String username, String password, String token) {
        Optional<Ban> optionalBan = banRepository.findByUsernameAndToken(username, token);
        Optional<User> optionalUserAccount = loginRepository.findByUsernameAndPasswordAndToken(username, password, token);
        Optional<User> optionalUser = loginRepository.findByUsernameAndPassword(username, password);
        if (optionalBan.isPresent()) {
            return 444;
        } else {
        if (optionalUserAccount.isPresent() && optionalUser.isPresent()) {
            User userAccount = optionalUserAccount.get();
            User user = optionalUser.get();
            LocalDate expirationDate = userAccount.getExpiration_date().toLocalDate();
            LocalDate today = LocalDate.now();
            if (!Objects.equals(user.getToken(), token)) {
                return 401;
            } else {
                if (today.isBefore(expirationDate)) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }else {
            return 404;
        }
    }
}
}
