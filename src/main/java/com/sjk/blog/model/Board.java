package com.sjk.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob //대용량 데이터
    private String content;

    @ColumnDefault("0")
    private int count; //조회수

    @ManyToOne(fetch = FetchType.EAGER)  //Many = board , One = user , 하나의 유저는 여러개의 게시글 작성 가능
    @JoinColumn(name="userId") //Join Column name = "userId"
    private User user; //DB는 오브젝트 저장 x, 자바는 오브젝트 저장 o ->JPA Join 사용

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) //mappedBy : 연관관계의 주인이 아니다.(FK가 아님), DB에 컬럼 생성 x
    private List<Reply> reply;  //댓글은 여러개

    @CreationTimestamp
    private Timestamp createDate;

}
/*
* 기본전략
* @OneToMany(fetch = FetchType.LAZY) : 연관관게에 있는 Entity를 가져오지 않고, getter로 접근할 때 가져온다
* @ManyToOne(fetch = FetchType.EAGER) : 연관 관계에 있는 Entity들 모두 가져온다
* 즉시 로딩이 필요하지 않은 것들은 LAZY 전략으로 바꿔줌
* */