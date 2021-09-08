package com.sjk.blog.repository;

import com.sjk.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//DAO 역할 (Data Access Object) -> 데이터 접근 함수
// 자동으로 Bean 등록
@Repository //생략 가능
public interface UserRepository extends JpaRepository<User, Integer> { //<무슨 테이블이 관리, PK속성>



}

// JPA Naming 쿼리
// SELECT * FROM user WHERE username= ?(username) AND password = ?(password);
//    User findByUserIdAndPassword(String userId, String password);

    /*//repository.login이 실행되면 쿼리문이 실행된다.
    @Query(value="SELECT * FROM user WHERE username= ?1 AND password = ?2", nativeQuery = true)
    User login(String username, String password);*/