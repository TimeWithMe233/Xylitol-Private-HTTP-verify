package com.alkaid.API.base.module;

import com.alkaid.API.base.module.body.RegBody;
import com.alkaid.API.base.module.register.RegService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/register")
public class RegisterController {
    @Autowired
    private RegService regService;

    @PostMapping
    public ResponseEntity<Map<String, String>> register(@RequestBody RegBody regBody) {
        boolean success = regService.register(regBody.getUsername(), regBody.getPassword(), regBody.getToken());
        Map<String, String> response = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (success) {
            response.put("message", "Register Success");
            return new ResponseEntity<>(response, headers, HttpStatus.OK);
        } else {
            response.put("message", "Register Failed");
            return new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
        }
    }
}
