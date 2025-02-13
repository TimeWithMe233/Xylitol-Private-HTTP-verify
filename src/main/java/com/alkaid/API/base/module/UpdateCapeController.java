package com.alkaid.API.base.module;

import com.alkaid.API.base.module.body.UpdateCapeBody;
import com.alkaid.API.base.module.update.UpdateCapeService;
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
@RequestMapping("api/updatecape")
public class UpdateCapeController {
    @Autowired
    private UpdateCapeService updateCapeService;

    @PostMapping
    public ResponseEntity<Map<String, String>> capeurl(@RequestBody UpdateCapeBody updateCapeBody) {
        boolean success = updateCapeService.capeurl(updateCapeBody.getUsername(), updateCapeBody.getCapeurl());
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
