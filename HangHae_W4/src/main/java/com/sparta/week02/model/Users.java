package com.sparta.week02.model;

import com.sparta.week02.dto.UsersDto;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity // 시간을 자동으로 반영하도록 설정
public class Users extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    public Users(String username, String password, String email, UserRoleEnum role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
//    public Users(String username, String password, UserRoleEnum role) {
//        this.username = username;
//        this.password = password;
//        this.role = role;
//    }
    public Users(UsersDto user, int id){
        this.id = id;
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.role = user.getRole();
    }

}
