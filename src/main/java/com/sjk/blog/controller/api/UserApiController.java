package com.sjk.blog.controller.api;

import com.sjk.blog.dto.ResponseDto;
import com.sjk.blog.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("UserAPiController 호출됨 ");
        //DB insert를 하고 return 하면된다.
        return new ResponseDto<Integer>(HttpStatus.OK, 1); //자바 오브젝트를 JSON으로 변환해서 리턴(Jackson)
    }
}
