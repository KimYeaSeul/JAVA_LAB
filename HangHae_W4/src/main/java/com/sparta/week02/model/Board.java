package com.sparta.week02.model;

import com.sparta.week02.dto.BoardDto;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
    private String password;

    @Lob
    private String content;

    @ManyToOne // many => board, one => user
    @JoinColumn(name = "author")
    private Users author; //DB는 object를 저장할 수 없다. FK사용, but Java는 object를 저장할 수 있다.

    @OneToMany(mappedBy = "board", fetch=FetchType.EAGER) //mappedBy는 연관관계의 주인이 아니다.(FK가 아니다.) DB에 컬럼을 만들지 마세요. Board를 Select할 때 Join문을 통해서 Reply값을 얻기 위해서 필요한거에용.
    private List<Comment> reply;

    public void update(BoardDto boardDto){
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();
    }
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

}
