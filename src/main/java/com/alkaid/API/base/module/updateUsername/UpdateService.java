package com.alkaid.API.base.module.updateUsername;

import com.alkaid.API.base.model.Ban;
import com.alkaid.API.base.model.User;
import com.alkaid.API.base.repository.BanRepository;
import com.alkaid.API.base.repository.RegRepository;
import com.alkaid.API.base.repository.UpdateRepository;
import com.alkaid.API.base.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class UpdateService {

    @Autowired
    private UpdateRepository updateRepository;

    @Autowired
    private UserRepository userRepository;

    public boolean lastName(String username, String lastName) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()){
            User update = optionalUser.get(); // 获取到现有用户对象
            update.setLastName(lastName); // 更新姓氏
            updateRepository.save(update); // 保存更新后的用户对象
            return true;
        } else {
            return false;
        }
    }
}
