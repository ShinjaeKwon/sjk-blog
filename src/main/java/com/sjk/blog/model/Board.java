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

    @ManyToOne  //Many = board , One = user , 하나의 유저는 여러개의 게시글 작성 가능
    @JoinColumn(name="userId") //Join Column name = "userId"
    private User user; //DB는 오브젝트 저장 x, 자바는 오브젝트 저장 o ->JPA Join 사용

    @CreationTimestamp
    private Timestamp createDate;

}
