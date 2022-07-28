package com.sparta.week01.api;

import com.sparta.week01.dto.BoardDto;
import com.sparta.week01.dto.ResponseDto;
import com.sparta.week01.model.Board;
import com.sparta.week01.repository.BoardRepository;
import com.sparta.week01.service.BoardService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    // 글쓰기
    @PostMapping("/api/boards")
    public ResponseDto<Board> write(@RequestBody Map<String,String> param){
        Board writeBoard = boardService.write(param);
        return new ResponseDto<>(true, writeBoard);
    }

    // 게시글 전체 목록
    @GetMapping("/api/boards")
    public ResponseDto<List<Board>> boardList(){
        List<Board> list = boardService.allList();
        return new ResponseDto<>(true, list);
    }

    // 특정 게시글 가져오기
    @GetMapping("/api/boards/{id}")
    public ResponseDto<Board> getBoard(@PathVariable int id){
        Board board = boardService.getBoard(id);
        return new ResponseDto<>(true, board);
    }

    // 특정 게시글 수정하기
    @PutMapping("/api/boards/{id}")
    public ResponseDto<Board> updateBoard(@PathVariable int id, @RequestBody BoardDto boardDto){
        Board boardId = boardService.updateBoard(id, boardDto);
        return new ResponseDto<>(true, boardId);
    }


    // 특정 게시글 삭제하기
    @DeleteMapping("/api/boards/{id}")
    public ResponseDto<Integer> deleteBoard(@PathVariable int id){
        int boardId = boardService.deleteBoard(id);
        return new ResponseDto<>(true, boardId);
    }

    // 비밀번호 확인하기
    @PostMapping("/api/boards/auth/{id}")
    public ResponseDto<String> certifyPw(@PathVariable int id, @RequestBody Map<String, String> map){
        return boardService.certifyPw(id, map);
    }
}
