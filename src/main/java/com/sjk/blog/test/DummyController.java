/*
package com.sjk.blog.test;

import com.sjk.blog.model.RoleType;
import com.sjk.blog.model.User;
import com.sjk.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;


@RestController
public class DummyController {

    @Autowired //스프링이 관리하는 객체중 UserRepository 객체가 있으면 클래스가 적재될때 같이 메모리에 적재해준다. -> 의존성 주입 (DI)
    private UserRepository userRepository;

    //회원 삭제 테스트
    @DeleteMapping("/dummy/user/{id}")
    public String delete(@PathVariable int id){
        try{
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            return "삭제에 실패하였습니다. 해당 id는 DB에 없습니다.";
        }


        return "삭제되었습니다. id : "+ id;
    }




    //save : id 전달시 insert, id 전달 안할 시 해당 id에 대한 데이터가 있으면  update, 없으면 insert
    //회원 수정 테스트
    //수정 목록 : password, birth, email, tel
    @Transactional //더티체킹을 사용하여 update
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser){  //RequestBody : JSON 데이터 받음, json => Java obj(Message Converter Jackson 라이브러리가 변환)
        System.out.println("password : "+ requestUser.getPassword());
        System.out.println("name : "+ requestUser.getNickname());
        System.out.println("email : "+ requestUser.getEmail());

        User user = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("수정에 실패하였습니다.");
        });
        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());

//        userRepository.save(user);
        return user;
    }

    //전체 유저 정보 확인 테스트
    @GetMapping("/dummy/users")
    public List<User> list(){
        return userRepository.findAll();
    }

    //한 페이지당 2건의 데이터를 리턴
    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size=2, sort ="id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<User> pagingUser = userRepository.findAll(pageable);

        List<User> users = pagingUser.getContent();
        return users;
    }

    //detail (람다식 사용)
*/
/*    public User detail(@PathVariable int id){ //@PathVariable로 파라미터를 받음 // 1. id값이 존재하지 않을 때 빈객체 return
        User user = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("해당 사용자는 없습니다. id : "+ id);
        });
        return user;
    }*//*


    //유저 정보 확인 테스트 (1명)
    //{id} 주소로 파라미터를 전달 받을 수 있다.
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id){ //@PathVariable로 파라미터를 받음 {id} // 1. id값이 존재하지 않을 때 빈객체 return
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 존재하지 않습니다. id : "+ id);
            }
        });

        //user 객체(자바 오브젝트) -> json 변환
        //스프링 부트 = MessageConverter 자동 작동 json으로 변환해줌
        return user;
    }


    //회원가입 테스트
    @PostMapping("/dummy/join")
    public String join(User user){ //매개변수만 적으면 key = value 데이터로 오는데, 알아서 함수에 파싱해준다.
        System.out.println("userId : "+ user.getUserId());
        System.out.println("password : "+ user.getPassword());
        System.out.println("name : "+ user.getNickname());
        System.out.println("email : "+ user.getEmail());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
*/
