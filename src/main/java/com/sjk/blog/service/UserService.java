package com.sjk.blog.service;

import com.sjk.blog.model.User;
import com.sjk.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다.
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public int 회원가입(User user){
        try{
            userRepository.save(user);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("UserService : 회원가입() : " + e.getMessage());
        }
        return -1;
    }

    @Transactional(readOnly = true) //SELECT 할 때 트랜잭션 시작, 서비스가 종료될 때 트랜잭션이 종료 (정합성 유지)
    public User 로그인(User user){

        return  userRepository.findByUserIdAndPassword(user.getUserId(), user.getPassword());
    }

}

//Service를 쓰는 이유
//트랜잭션 관리
//서비스의 의미 때문