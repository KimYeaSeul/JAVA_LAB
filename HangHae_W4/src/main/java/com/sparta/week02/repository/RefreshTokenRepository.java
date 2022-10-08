package com.sparta.week02.repository;

import com.sparta.week02.model.RefreshToken;
import com.sparta.week02.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {

    RefreshToken findByUser(Users user);

}
