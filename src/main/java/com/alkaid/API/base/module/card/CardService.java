package com.alkaid.API.base.module.card;

import com.alkaid.API.base.model.Card;
import com.alkaid.API.base.model.User;
import com.alkaid.API.base.repository.CardRepository;
import com.alkaid.API.base.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public List<String> createCard(String time, int count, String rank) {
        List<String> cards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Card card = new Card();
            String code = generateRandomCode();
            card.setCode(code);
            card.setDurationType(time);
            card.setRank(rank);
            card.setUsed(false);
            cardRepository.save(card);
            cards.add(card.getCode());
        }
        return cards;
    }
    private static String generateRandomCode() {
        // 定义字符集，包括大写字母、小写字母、数字和一些符号
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("DreamDev-");

        // 生成前三部分，每部分8个字符
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(chars.charAt(random.nextInt(chars.length())));
            }
            sb.append("-");
        }

        // 生成最后一部分，4个字符
        for (int j = 0; j < 4; j++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        return sb.toString();
    }
}
