package com.alkaid.API.base.module;

import com.alkaid.API.base.module.body.InfoBody;
import com.alkaid.API.base.module.body.ApiResponse;
import com.alkaid.API.base.module.body.UserInfoResponse;
import com.alkaid.API.base.module.user.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserInfoResponse>> getUserInfo(@RequestBody InfoBody infoBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println(infoBody.getData());
        UserInfoResponse userInfoResponse = userInfoService.getUserInfo(infoBody.getData());
        ApiResponse<UserInfoResponse> apiResponse = new ApiResponse<>();
        if (userInfoResponse != null) {
            apiResponse.setData(userInfoResponse);
            apiResponse.setStatus(true);
            apiResponse.setMessage("success");
        } else {
            apiResponse.setStatus(false);
            apiResponse.setMessage("error");
        }
        return new ResponseEntity<>(apiResponse, headers, HttpStatus.OK);
    }
}
