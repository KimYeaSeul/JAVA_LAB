package com.sparta.week02.controller;

import com.sparta.week02.model.Users;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name="userId")
    private Users user;

    private String refreshToken;

    @Builder
    public RefreshToken(Users user, String token) {
        this.user = user;
        this.refreshToken = token;
    }

    public RefreshToken updateValue(String token) {
        this.refreshToken = token;
        return this;
    }

}
