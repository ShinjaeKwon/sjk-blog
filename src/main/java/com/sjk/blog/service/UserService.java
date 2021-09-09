package com.sjk.blog.service;

import com.sjk.blog.model.RoleType;
import com.sjk.blog.model.User;
import com.sjk.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다.
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encode;

    @Transactional
    public void 회원가입(User user){
            String rawPassword = user.getPassword(); //원래 패스워드
            String encPassword = encode.encode(rawPassword); //패스워드 인코딩 해줌
            user.setPassword(encPassword);
            user.setRole(RoleType.USER);
            userRepository.save(user);

    }

 /*   @Transactional(readOnly = true) //SELECT 할 때 트랜잭션 시작, 서비스가 종료될 때 트랜잭션이 종료 (정합성 유지)
    public User 로그인(User user){

        return  userRepository.findByUserIdAndPassword(user.getUserId(), user.getPassword());
    }*/

}

//Service를 쓰는 이유
//트랜잭션 관리
//서비스의 의미 때문