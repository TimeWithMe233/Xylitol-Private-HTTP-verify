package com.alkaid.API.base.module.ban;

import com.alkaid.API.base.model.Ban;
import com.alkaid.API.base.model.User;
import com.alkaid.API.base.repository.BanRepository;
import com.alkaid.API.base.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

/**
 * @Author: DreamDev
 * @Date: 2024/10/26
 * Time:22:24
 */
@Service
public class BanService {
    @Autowired
    private BanRepository banRepository;
    @Autowired
    private UserRepository userRepository;

    public String BanUser(String username){
        Ban ban = new Ban();
        String token;
        Optional<User> optionalUser =  userRepository.findByUsername(username);

        if (optionalUser.isPresent()){
            token = optionalUser.get().getToken();
        } else {
            return "User not found";
        }
        ban.setUsername(username);
        ban.setToken(token);
        banRepository.save(ban);
        return username + " has banned successfully";
    }
    public String UnbanUser(String username){
        Optional<Ban> optionalBanUser =  banRepository.findByUsername(username);
        if (optionalBanUser.isPresent()){
            Ban ban = optionalBanUser.get();
            banRepository.delete(ban);//不知道有用吗等着试试
            return "User unbanned successfully";
        } else {
            return "User not found";
        }
    }

}
