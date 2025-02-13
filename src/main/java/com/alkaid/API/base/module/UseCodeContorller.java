package com.alkaid.API.base.module;

import com.alkaid.API.base.module.body.UseBody;
import com.alkaid.API.base.module.usecode.UseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/use")
public class UseCodeContorller {
    @Autowired
    private UseService useCodeService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createUseCode(@RequestBody UseBody useBody) {
        Map<String, Object> response = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (useCodeService.useCardCode(useBody.getCode(), useBody.getUsername())) {
            response.put("success", true);
            return new ResponseEntity<>(response, headers, HttpStatus.OK);
        } else {
            response.put("message", "Error");
            return new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
        }
    }
}
