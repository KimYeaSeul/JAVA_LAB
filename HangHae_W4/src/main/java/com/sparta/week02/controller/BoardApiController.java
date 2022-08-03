package com.sparta.week02.controller;

import com.sparta.week02.dto.BoardDto;
import com.sparta.week02.dto.BoardResponseDto;
import com.sparta.week02.dto.ResponseDto;
import com.sparta.week02.model.Board;
import com.sparta.week02.repository.BoardRepository;
import com.sparta.week02.security.UserDetailsImpl;
import com.sparta.week02.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardService boardService;
    private final BoardRepository boardRepository;

    // 글쓰기
    @PostMapping("/api/boards")
    public ResponseDto<BoardResponseDto> write(@RequestBody Board board
    ,@AuthenticationPrincipal UserDetailsImpl userDetails){
        System.out.println("글쓰기 테스트");
        BoardResponseDto writeBoard = boardService.write(board, userDetails.getUser());
        return new ResponseDto<>("SUCCESS", writeBoard);
    }

    // 게시글 전체 목록
    @GetMapping("/boards")
    public ResponseDto<List<Board>> boardList(){
        List<Board> list = boardService.allList();
        return new ResponseDto<>("SUCCESS", list);
    }

    // 특정 게시글 가져오기
    @GetMapping("/boards/{id}")
    public ResponseDto<Board> getBoard(@PathVariable int id){
        Board board = boardService.getBoard(id);
        return new ResponseDto<>("SUCCESS", board);
    }

    // 특정 게시글 수정하기
    @PutMapping("/api/boards/{id}")
    public ResponseDto<Board> updateBoard(@PathVariable int id,
                                          @RequestBody BoardDto boardDto,
                                          @AuthenticationPrincipal UserDetailsImpl userDetails){
        Board boardId = boardService.updateBoard(id, boardDto, userDetails.getUser());
        return new ResponseDto<>("SUCCESS", boardId);
    }


    // 특정 게시글 삭제하기
    @DeleteMapping("/api/boards/{id}")
    public ResponseDto<String> deleteBoard(@PathVariable int id,
                                            @AuthenticationPrincipal UserDetailsImpl userDetails){
        int boardId = boardService.deleteBoard(id, userDetails.getUser());
        String message = " Board " + boardId + " Delete SUCCESS";
        return new ResponseDto<>("SUCCESS", message);
    }

    // 비밀번호 확인하기
    @PostMapping("/api/boards/auth/{id}")
    public ResponseDto<String> certifyPw(@PathVariable int id, @RequestBody Map<String, String> map){
        return boardService.certifyPw(id, map);
    }
}
