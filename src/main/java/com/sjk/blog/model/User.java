package com.sjk.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //클래스가 MySql에 테이블로 생성 , ORM -> Java Object -> 테이블 매핑
public class User {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //넘버링 전략 IDENTITY : DB의 넘버링 전략을 따라감
    private int id; //auto_increment (Auto)

    @Column(nullable = false, length = 20)
    private String username; //아이디

    @Column(nullable = false, length = 100)
    private String password; //패스워드

    @ColumnDefault("'user'")
    private String role; //권한

    @Column(nullable = false, length = 20)
    private String name; //이름

    @Column(nullable = false, length = 8)
    private String birth; //생년월일 (YYMMDD)

    @Column(nullable = false, length = 50)
    private String email; //이메일

    @Column(nullable = false, length = 20)
    private String tel; //전화번호



    @CreationTimestamp //시간 자동 입력 (Auto)
    private Timestamp createDate;
}
