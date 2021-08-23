package com.sjk.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reply { //댓글

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 200)
    private String content;

    @ManyToOne //Many = reply, One = board , 하나의 게시글에는 여러개의 댓글이 존재
    @JoinColumn(name="boardId")
    private Board board;

    @ManyToOne //Many = reply, One = user , 하나의 유저는 여러개의 댓글 작성 가능
    @JoinColumn(name="userId")
    private User user;

    @CreationTimestamp
    private Timestamp createDate;

}
