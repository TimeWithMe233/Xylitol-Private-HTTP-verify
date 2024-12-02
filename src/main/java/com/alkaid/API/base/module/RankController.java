package com.alkaid.API.base.module;

import com.alkaid.API.base.module.body.RankBody;
import com.alkaid.API.base.module.rank.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RankController {

    @Autowired
    private RankService rankService;

    @PostMapping("api/rank/get")
    public ResponseEntity<Map<String, Object>> rank(@RequestBody String username) {
        Map<String, Object> response = new HashMap<>();
        response.put("rank", rankService.getRank(username));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }
    @PostMapping("api/rank/set")
    public ResponseEntity<Map<String, Object>> setRank(@RequestBody RankBody rankBody) {
        Map<String, Object> response = new HashMap<>();
        response.put("updated", rankService.setRank(rankBody.getUsername(), rankBody.getRank()));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }


}
