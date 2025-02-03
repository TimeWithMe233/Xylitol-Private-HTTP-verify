package com.alkaid.API.base.module;

import com.alkaid.API.base.module.body.LoginBody;
import com.alkaid.API.base.module.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginBody loginBody) {
        int i = loginService.login(loginBody.getUsername(), loginBody.getPassword(),loginBody.getToken());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> response = new HashMap<>();
        switch (i){
            case 1:
                response.put("data", loginBody.getToken());
                return new ResponseEntity<>(response, headers, HttpStatus.OK);
            case 0:
                response.put("message", "Insufficient use time");
                return new ResponseEntity<>(response, headers, HttpStatus.NOT_EXTENDED);
            case 401:
                response.put("message", "Wrong HWID");
                return new ResponseEntity<>(response, headers, HttpStatus.NOT_FOUND);
            case 404:
                response.put("message", "No Found Your Account");
                return new ResponseEntity<>(response, headers, HttpStatus.NOT_FOUND);
            case 444:
                response.put("message", "Your Account is Banned");
                return new ResponseEntity<>(response, headers, HttpStatus.NOT_FOUND);
        }
        response.put("message", "Unknown Error");
        return new ResponseEntity<>(response, headers, HttpStatus.NOT_FOUND);
    }
}
