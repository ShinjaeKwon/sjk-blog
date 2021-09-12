package com.sjk.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //클래스가 MySql에 테이블로 생성 , ORM -> Java Object -> 테이블 매핑\
//@DynamicInsert //insert 할 때 null인 컬럼 제외
public class User {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //넘버링 전략 IDENTITY : DB의 넘버링 전략을 따라감
    private int id; //auto_increment (Auto)

    @Column(nullable = false, length = 20, unique = true)
    private String username; //아이디

    @Column(nullable = false, length = 100)
    private String password; //패스워드

//  @ColumnDefault("'user'")
    // DB는 RoleType이 없음
    @Enumerated(EnumType.STRING) //ENUM 타입이 String 타입이라고 알려줌
    private RoleType role; //권한 (USER, ADMIN)

    @Column(nullable = false, length = 20, unique = true)
    private String nickname; //닉네임

    @Column(nullable = false, length = 50, unique = true)
    private String email; //이메일

    @CreationTimestamp //시간 자동 입력 (Auto)
    private Timestamp createDate;
}

