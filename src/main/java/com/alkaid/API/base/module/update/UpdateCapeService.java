package com.alkaid.API.base.module.update;

import com.alkaid.API.base.model.User;
import com.alkaid.API.base.repository.UpdateRepository;
import com.alkaid.API.base.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateCapeService {

    @Autowired
    private UpdateRepository updateRepository;

    @Autowired
    private UserRepository userRepository;

    public boolean capeurl(String username, String capeurl) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()){
            User update = optionalUser.get(); // 获取到现有用户对象
            update.setCapeurl(capeurl); // 更新姓氏
            updateRepository.save(update); // 保存更新后的用户对象
            return true;
        } else {
            return false;
        }
    }
}
