package com.sjk.blog.controller;

import com.sjk.blog.model.RoleType;
import com.sjk.blog.model.User;
import com.sjk.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DummyController {

    @Autowired //스프링이 관리하는 객체중 UserRepository 객체가 있으면 클래스가 적재될때 같이 메모리에 적재해준다. -> 의존성 주입 (DI)
    private UserRepository userRepository;

    @PostMapping("/dummy/join")
    public String join(User user){ //매개변수만 적으면 key = value 데이터로 오는데, 알아서 함수에 파싱해준다.
        System.out.println("username : "+ user.getUsername());
        System.out.println("password : "+ user.getPassword());
        System.out.println("name : "+ user.getName());
        System.out.println("birth : "+ user.getBirth());
        System.out.println("email : "+ user.getEmail());
        System.out.println("tel : "+ user.getTel());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
