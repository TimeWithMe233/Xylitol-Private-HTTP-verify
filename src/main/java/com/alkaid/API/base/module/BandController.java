package com.alkaid.API.base.module;

import com.alkaid.API.base.module.body.BanBody;
import com.alkaid.API.base.module.ban.BanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: DreamDev
 * @Date: 2024/10/26
 * Time:22:50
 */
@RestController
public class BandController {
    @Autowired
    private BanService bandService;

    @PostMapping("api/ban")
    public ResponseEntity<String> BanUser(@RequestBody BanBody banBody){
        String result = bandService.BanUser(banBody.getUsername());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(result, headers, HttpStatus.OK);
    }
    @PostMapping("api/unban")
    public ResponseEntity<String> UnbanUser(@RequestBody BanBody banBody){
        String result = bandService.UnbanUser(banBody.getUsername());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(result, headers, HttpStatus.OK);
    }
}
