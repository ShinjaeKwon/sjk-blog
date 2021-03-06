package com.sjk.blog.controller.api;

import com.sjk.blog.dto.ResponseDto;
import com.sjk.blog.model.RoleType;
import com.sjk.blog.model.User;
import com.sjk.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;



    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("UserAPiController 호출됨 ");
        //DB insert를 하고 return 하면된다

        userService.회원가입(user);

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); //자바 오브젝트를 JSON으로 변환해서 리턴(Jackson)
    }
    //시큐리티를 사용하면 세션이 자동으로 생긴다.




}
//HttpSession session : 필요한 함수의 매개변수로 적어 사용할 수도 있고, 변수로 써서 사용할 수도 있다.
//시큐리티를 사용하지 않고 로그인 구현
/*    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
        System.out.println("UserAPiController : login호출됨 ");
        User principal = userService.로그인(user);  //principal(접근주체)

        if(principal != null){
            session.setAttribute("principal", principal); //세션을 만듬
        }
        return new ResponseDto<>(HttpStatus.OK.value(), 1); //자바 오브젝트를 JSON으로 변환해서 리턴(Jackson)
    }*/