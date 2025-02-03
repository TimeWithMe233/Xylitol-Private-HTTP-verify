package com.alkaid.API.base.module.usecode;

import com.alkaid.API.base.json.JsonRequest;
import com.alkaid.API.base.model.Card;
import com.alkaid.API.base.model.User;
import com.alkaid.API.base.repository.CardRepository;
import com.alkaid.API.base.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class UseService {
    @Autowired
    private UserRepository userAccountRepository;
    @Autowired
    private CardRepository cardCodeRepository;

    public boolean useCardCode(String code, String accountId, Boolean isBeta) {
        Optional<Card> optionalCardCode = cardCodeRepository.findByCode(code);

        if (optionalCardCode.isPresent()) {
            Card cardCode = optionalCardCode.get();
            if (cardCode.isUsed()) {
                return false; // 卡密已经使用
            }
            // 获取用户账户信息
            Optional<User> optionalUserAccount = userAccountRepository.findByUsername(accountId);
            if (optionalUserAccount.isPresent()) {
                User userAccount = optionalUserAccount.get();
                userAccount.setRanks(cardCode.getRank());
                // 检查 isBeta 是否为 null
                if (isBeta != null) {
                    userAccount.setIsbeta(isBeta);
                } else {
                    // 处理 isBeta 为 null 的情况，例如设置为默认值
                    userAccount.setIsbeta(false); // 假设默认值为 false
                }
                LocalDate newExpiration = calculateNewExpiration(userAccount.getExpiration_date().toLocalDate(), cardCode.getDurationType());
                userAccount.setExpiration_date(Date.valueOf(newExpiration));
                userAccountRepository.save(userAccount); // 更新用户账户过期时间

                // 更新卡密为已使用
                cardCode.setUsed(true);
                cardCodeRepository.save(cardCode);

                return true; // 成功使用卡密
            }
        }
        return false; // 卡密不存在或账户不存在
    }

    private LocalDate calculateNewExpiration(LocalDate currentExpiration, String durationType) {
        switch (durationType) {
            case "1D","1d":
                return currentExpiration.plusDays(1);
            case "1W","7d":
                return currentExpiration.plusWeeks(1);
            case "1M","30d":
                return currentExpiration.plusMonths(1);
            case "1Y","365d":
                return currentExpiration.plusYears(1);
            case "forever","lifetime": // 修正拼写错误
                return currentExpiration.plusYears(Math.multiplyExact(1, 1000)); // 千年
            default:
                throw new IllegalArgumentException("Invalid duration type: " + durationType);
        }
    }
}
