package com.sparta.week02.service;

import com.sparta.week02.dto.BoardDto;
import com.sparta.week02.dto.ResponseDto;
import com.sparta.week02.model.Board;
import com.sparta.week02.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public Board write(Map<String,String> param){
//        System.out.println("pw : " + pw);
        Board writeBoard = Board.builder()
                .title(param.get("title"))
                .content(param.get("content"))
                .author(param.get("author"))
                .password(param.get("password"))
                .build();
        return boardRepository.save(writeBoard);
    }

    @Transactional(readOnly = true)
    public List<Board> allList(){

        return boardRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Board getBoard(int id){
        return boardRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
    }


    // public int update(int id, Board board){
    // Dto 사용
    @Transactional
    public Board updateBoard(int id, BoardDto boardDto){
        // 영속화
        Board updateBoard = boardRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
        updateBoard.update(boardDto);
        return updateBoard;
    }

    public int deleteBoard(int id) {
        try{
            boardRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }

    public ResponseDto<String> certifyPw(int id, Map<String, String> map) {
        String pw = map.get("password");
//        System.out.println("password = " + pw);
        Board board = boardRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );

        if(board != null)
            if(board.getPassword().equals(pw))
                return new ResponseDto<>(true, "비밀번호가 일치합니다.");

        return new ResponseDto<>(false,"비밀번호가 일치하지 않습니다.");
    }

}
