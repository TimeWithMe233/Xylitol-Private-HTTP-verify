package com.alkaid.API.base.module.register;

import com.alkaid.API.base.model.Ban;
import com.alkaid.API.base.model.User;
import com.alkaid.API.base.repository.BanRepository;
import com.alkaid.API.base.repository.RegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class RegService {

    @Autowired
    private RegRepository regRepository;

    @Autowired
    private BanRepository banRepository;

    public boolean register(String username, String password, String token) {
        Optional<Ban> optionalBan = banRepository.findByToken(token);
        if (optionalBan.isPresent()) {
            return false;
        } else {
            User reg = new User();
            reg.setUsername(username);
            reg.setPassword(password);
            reg.setToken(token);
            reg.setRanks("User");//String?是 沃日 你rank能不能和卡密绑定啥玩意
            reg.setIsbeta(false);
            reg.setExpiration_date(Date.valueOf(LocalDate.now()));
            regRepository.save(reg);
            return true;
        }
    }

}
