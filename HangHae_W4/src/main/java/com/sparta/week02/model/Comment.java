package com.sparta.week02.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="boardId")
    private Board board;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="userId")
    private Users author;

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
