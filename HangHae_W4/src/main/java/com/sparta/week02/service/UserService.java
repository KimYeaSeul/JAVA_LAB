package com.sparta.week02.service;

import com.sparta.week02.dto.SignupRequestDto;
import com.sparta.week02.model.Users;
import com.sparta.week02.model.UserRoleEnum;
import com.sparta.week02.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private static final String ADMIN_TOKEN="diffkdiffkdiffktyddiffkfldiffk";

    public void registerUser(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        Optional<Users> found = userRepository.findByUsername(username);

        if(found.isPresent()){
            throw new IllegalArgumentException("중복된 사용자 ID가 존재합니다.");
        }

        String email= requestDto.getEmail();
        UserRoleEnum role = UserRoleEnum.USER;
        if(requestDto.isAdmin()){
            if(!requestDto.getAdminToken().equals(ADMIN_TOKEN)){
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가합니다.");
            }
            role = UserRoleEnum.ADMIN;
        }

        Users user = new Users(username, password, email, role);
        userRepository.save(user);
    }
}
