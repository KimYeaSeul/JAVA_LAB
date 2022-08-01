package com.sparta.week02.model;

import com.sparta.week02.dto.BoardDto;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor // 매개변수를 갖지 않는 constructor
@AllArgsConstructor // 모든 변수를 매개변수로 갖는 constructor
@Builder // builder 패턴 사용 가능
@Entity  // JPA로 관리되는 객체라는 것을 의미. 자동으로 테이블 생성
@EntityListeners(AuditingEntityListener.class) // 시간을 자동으로 반영하도록 설정
public class Board extends Timestamped{

    @Id // 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 내가 설정한 database의 전략을 따라가겠다.
    private int id;

    // 꼭 입력값이 필요함.
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String password;

    @Lob
    private String content;

    public void update(BoardDto boardDto){
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();
        this.author = boardDto.getAuthor();
    }
//    // 생성일 자동으로 넣어줌
//    @CreatedDate
    private LocalDateTime createAt;

//    @LastModifiedDate
    private LocalDateTime modifiedAt;

}
