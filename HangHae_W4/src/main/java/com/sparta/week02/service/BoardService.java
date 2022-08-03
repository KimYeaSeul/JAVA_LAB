package com.sparta.week02.service;

import com.sparta.week02.dto.BoardDto;
import com.sparta.week02.dto.BoardResponseDto;
import com.sparta.week02.dto.ResponseDto;
import com.sparta.week02.handler.CustomException;
import com.sparta.week02.handler.ErrorResponse;
import com.sparta.week02.model.Board;
import com.sparta.week02.model.Users;
import com.sparta.week02.repository.BoardRepository;
import com.sparta.week02.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardService {


    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public BoardResponseDto write(Board board, Users user){
//        System.out.println("pw : " + pw);
        System.out.println("누구냐능 "+ user.getUsername());
        Board writeBoard = Board.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .author(user)
                .password(board.getPassword())
                .build();
        System.out.println("저장됐냐능" + writeBoard);
        boardRepository.save(writeBoard);
        BoardResponseDto brd = BoardResponseDto.builder()
                .id(writeBoard.getId())
                .title(writeBoard.getTitle())
                .content(writeBoard.getContent())
                .author(writeBoard.getAuthor().getUsername())
                .build();
        return brd;
    }

    @Transactional(readOnly = true)
    public List<Board> allList(){

        return boardRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Board getBoard(int id){
        return boardRepository.findById(id).orElseThrow(()->
                new CustomException(ErrorResponse.NOT_FOUND_BOARD));
    }


    // public int update(int id, Board board){
    // Dto 사용
    @Transactional
    public Board updateBoard(int id, BoardDto boardDto, Users user){
        // 영속화
        Board updateBoard = boardRepository.findById(id).orElseThrow(
                ()-> new CustomException(ErrorResponse.NOT_FOUND_BOARD));
//        System.out.println("작성자 : " +updateBoard.getAuthor().getUsername() );
//        System.out.println("로그인자 : " + user.getUsername());
        if(updateBoard.getAuthor().getUsername().equals(user.getUsername())){
            updateBoard.update(boardDto);
            return updateBoard;
        }else{
           throw new CustomException(ErrorResponse.NOT_MATCH_USER);
        }
    }

    public int deleteBoard(int id, Users user) {
        Board updateBoard = boardRepository.findById(id).orElseThrow(
                ()-> new CustomException(ErrorResponse.NOT_FOUND_BOARD));
        if(updateBoard.getAuthor().getUsername().equals(user.getUsername())){
            boardRepository.deleteById(id);
            return id;
        }else{
            throw new CustomException(ErrorResponse.NOT_MATCH_USER);
        }
    }

    public ResponseDto<String> certifyPw(int id, Map<String, String> map) {
        String pw = map.get("password");
//        System.out.println("password = " + pw);
        Board board = boardRepository.findById(id).orElseThrow(
                ()-> new CustomException(ErrorResponse.NOT_FOUND_BOARD));

        if(board != null)
            if(board.getPassword().equals(pw))
                return new ResponseDto<>("SUCCESS", "비밀번호가 일치합니다.");

        return new ResponseDto<>("ERROR","비밀번호가 일치하지 않습니다.");
    }

}
