package com.alkaid.API.base.module.rank;

import com.alkaid.API.base.json.JsonRequest;
import com.alkaid.API.base.model.User;
import com.alkaid.API.base.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class RankService {
    @Autowired
    private UserRepository rankRepository;

    public String getRank(String username) {
        Optional<User> rank = rankRepository.findByUsername(JsonRequest.extractData(username, "username"));
        if (rank.isPresent()) {
            User r = rank.get();
            return r.getRanks();
        } else {
            return "No rank found for user: " + username;
        }
    }
    public String setRank(String username, String ranks) {
        Optional<User> rank = rankRepository.findByUsername(username);
        if (rank.isPresent()) {
            User r = rank.get();
            r.setRanks(ranks);
            rankRepository.save(r);
            return "User: " + username + " rank updated to: " + ranks;
        } else {
            User r = new User();
            r.setRanks(ranks);
            rankRepository.save(r);
            return "User: " + username + " rank created with rank: " + ranks;
        }
    }
}
