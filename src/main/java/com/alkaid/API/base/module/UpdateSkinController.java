package com.alkaid.API.base.module;

import com.alkaid.API.base.module.body.UpdateCapeBody;
import com.alkaid.API.base.module.body.UpdateSkinBody;
import com.alkaid.API.base.module.update.UpdateSkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: DreamDev
 * @Date: 2024/10/31
 * Time:20:20
 */
@RestController
@RequestMapping("api/updateskin")
public class UpdateSkinController {
    @Autowired
    private UpdateSkinService updateSkinService;

    @PostMapping
    public ResponseEntity<Map<String, String>> skinurl(@RequestBody UpdateSkinBody updateBody) {
        boolean success = updateSkinService.skinurl(updateBody.getUsername(), updateBody.getSkinurl());
        Map<String, String> response = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (success) {
            response.put("message", "Update Success");
            return new ResponseEntity<>(response, headers, HttpStatus.OK);
        } else {
            response.put("message", "Update Failed");
            return new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
        }
    }
}
