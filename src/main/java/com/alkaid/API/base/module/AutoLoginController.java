package com.alkaid.API.base.module;

import com.alkaid.API.base.module.autologin.AutoLoginService;
import com.alkaid.API.base.module.body.ApiResponse;
import com.alkaid.API.base.module.body.InfoBody;
import com.alkaid.API.base.module.body.LoginInfoResponse;
import com.alkaid.API.base.module.body.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: DreamDev
 * @Date: 2024/11/2
 * Time:10:14
 */
@RestController
@RequestMapping("api/autologin")
public class AutoLoginController {
    @Autowired
    private AutoLoginService autoLoginService;

    @RequestMapping
    public ResponseEntity<ApiResponse<LoginInfoResponse>> autoLogin(@RequestBody InfoBody infoBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println(infoBody.getData());
        LoginInfoResponse loginInfoResponse = autoLoginService.autoLogin(infoBody.getData());
        ApiResponse<LoginInfoResponse> apiResponse = new ApiResponse<>();
        if (loginInfoResponse != null) {
            apiResponse.setData(loginInfoResponse);
            apiResponse.setStatus(true);
            apiResponse.setMessage("Auto login success");
        } else {
            apiResponse.setStatus(false);
            apiResponse.setMessage("Auto login failed");
        }
        return new ResponseEntity<>(apiResponse, headers, HttpStatus.OK);
    }

}
