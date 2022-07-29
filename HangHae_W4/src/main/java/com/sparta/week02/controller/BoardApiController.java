package com.sparta.week02.controller;

import com.sparta.week02.dto.BoardDto;
import com.sparta.week02.dto.ResponseDto;
import com.sparta.week02.model.Board;
import com.sparta.week02.repository.BoardRepository;
import com.sparta.week02.service.BoardService;
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

    @GetMapping("/")
    public String home(){
        return "<h1>Welcome to Page</h1><h2>항해 3주차 개인프로젝트 페이지</h2><h3>API 명세서</h3>" +
                "<table style=\"border-collapse: collapse; width: 100%; height: 108px;\" border=\"1\" data-ke-align=\"alignLeft\">\n" +
                "<tr style=\"height: 18px;\">\n" +
                "<td style=\"width: 8.60469%; height: 18px;\">Method</td>\n" +
                "<td style=\"width: 19.0116%; height: 18px;\">URL</td>\n" +
                "<td style=\"width: 16.8024%; height: 18px;\">function</td>\n" +
                "<td style=\"width: 22.5582%; height: 18px;\">Request</td>\n" +
                "<td style=\"width: 33.0232%; height: 18px;\">Response</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 18px;\">\n" +
                "<td style=\"width: 8.60469%; height: 18px;\">GET</td>\n" +
                "<td style=\"width: 19.0116%; height: 18px;\">/api/boards</td>\n" +
                "<td style=\"width: 16.8024%; height: 18px;\">전체 게시글 목록</td>\n" +
                "<td style=\"width: 22.5582%; height: 18px;\">-</td>\n" +
                "<td style=\"width: 33.0232%; height: 18px;\">{<br />&nbsp;&nbsp;&nbsp;&nbsp;\"success\":&nbsp;true,<br />&nbsp;&nbsp;&nbsp;&nbsp;\"data\":&nbsp;[<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"id\":&nbsp;1,<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"title\":&nbsp;\"title1\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"author\":&nbsp;\"kim\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"password\":&nbsp;\"1234\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"content\":&nbsp;\"content1\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"createAt\":&nbsp;\"2022-07-28T05:03:59.022+00:00\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"modifiedAt\":&nbsp;\"2022-07-28T05:03:59.022+00:00\"<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"id\":&nbsp;2,<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"title\":&nbsp;\"title2\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"author\":&nbsp;\"kim\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"password\":&nbsp;\"1234\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"content\":&nbsp;\"content2\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"createAt\":&nbsp;\"2022-07-28T05:15:53.095+00:00\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"modifiedAt\":&nbsp;\"2022-07-28T05:15:53.095+00:00\"<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"id\":&nbsp;3,<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"title\":&nbsp;\"title3\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"author\":&nbsp;\"kim\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"password\":&nbsp;\"1234\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"content\":&nbsp;\"content3\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"createAt\":&nbsp;\"2022-07-28T05:23:32.393+00:00\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"modifiedAt\":&nbsp;\"2022-07-28T05:23:32.393+00:00\"<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br />&nbsp;&nbsp;&nbsp;&nbsp;]<br />}</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 18px;\">\n" +
                "<td style=\"width: 8.60469%; height: 18px;\">GET</td>\n" +
                "<td style=\"width: 19.0116%; height: 18px;\">/api/boards/{id}</td>\n" +
                "<td style=\"width: 16.8024%; height: 18px;\">특정 게시글 가져오기</td>\n" +
                "<td style=\"width: 22.5582%; height: 18px;\">-</td>\n" +
                "<td style=\"width: 33.0232%; height: 18px;\">{<br />&nbsp;&nbsp;&nbsp;&nbsp;\"success\":&nbsp;true,<br />&nbsp;&nbsp;&nbsp;&nbsp;\"data\":&nbsp;{<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"id\":&nbsp;3,<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"title\":&nbsp;\"title3\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"author\":&nbsp;\"kim\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"password\":&nbsp;\"1234\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"content\":&nbsp;\"content3\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"createAt\":&nbsp;\"2022-07-28T05:23:32.393+00:00\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"modifiedAt\":&nbsp;\"2022-07-28T05:23:32.393+00:00\"<br />&nbsp;&nbsp;&nbsp;&nbsp;}<br />}</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 18px;\">\n" +
                "<td style=\"width: 8.60469%; height: 18px;\">POST</td>\n" +
                "<td style=\"width: 19.0116%; height: 18px;\">/api/boards</td>\n" +
                "<td style=\"width: 16.8024%; height: 18px;\">글쓰기</td>\n" +
                "<td style=\"width: 22.5582%; height: 18px;\">{<br />\"title\"&nbsp;:&nbsp;\"title3\",<br />\"author\"&nbsp;:&nbsp;\"kim\",<br />\"content\"&nbsp;:&nbsp;\"content3\",<br />\"password\"&nbsp;:&nbsp;\"1234\"<br />}</td>\n" +
                "<td style=\"width: 33.0232%; height: 18px;\">{<br />&nbsp;&nbsp;&nbsp;&nbsp;\"success\":&nbsp;true,<br />&nbsp;&nbsp;&nbsp;&nbsp;\"data\":&nbsp;{<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"id\":&nbsp;3,<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"title\":&nbsp;\"title3\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"author\":&nbsp;\"kim\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"password\":&nbsp;\"1234\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"content\":&nbsp;\"content3\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"createAt\":&nbsp;\"2022-07-28T05:23:32.393+00:00\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"modifiedAt\":&nbsp;\"2022-07-28T05:23:32.393+00:00\"<br />&nbsp;&nbsp;&nbsp;&nbsp;}<br />}</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 18px;\">\n" +
                "<td style=\"width: 8.60469%; height: 18px;\">POST</td>\n" +
                "<td style=\"width: 19.0116%; height: 18px;\">/api/boards/auth/{id}</td>\n" +
                "<td style=\"width: 16.8024%; height: 18px;\">비밀번호 확인하기</td>\n" +
                "<td style=\"width: 22.5582%; height: 18px;\">password : 1234<br /><br />password : 12345</td>\n" +
                "<td style=\"width: 33.0232%; height: 18px;\">{<br />&nbsp;&nbsp;&nbsp;&nbsp;\"success\":&nbsp;true,<br />&nbsp;&nbsp;&nbsp;&nbsp;\"data\":&nbsp;\"비밀번호가&nbsp;일치합니다.\"<br />}<br /><br />{<br />&nbsp;&nbsp;&nbsp;&nbsp;\"success\":&nbsp;false,<br />&nbsp;&nbsp;&nbsp;&nbsp;\"data\":&nbsp;\"비밀번호가&nbsp;일치하지&nbsp;않습니다.\"<br />}</td>\n" +
                "</tr>\n" +
                "<tr style=\"height: 18px;\">\n" +
                "<td style=\"width: 8.60469%; height: 18px;\">PUT</td>\n" +
                "<td style=\"width: 19.0116%; height: 18px;\">/api/boards/{id}</td>\n" +
                "<td style=\"width: 16.8024%; height: 18px;\">특정 게시글 수정하기</td>\n" +
                "<td style=\"width: 22.5582%; height: 18px;\">{<br />&nbsp;&nbsp;&nbsp;&nbsp;\"title\"&nbsp;:&nbsp;\"title3&nbsp;update\",<br />&nbsp;&nbsp;&nbsp;&nbsp;\"author\"&nbsp;:&nbsp;\"kim\",<br />&nbsp;&nbsp;&nbsp;&nbsp;\"content\"&nbsp;:&nbsp;\"content3&nbsp;update\"<br />}</td>\n" +
                "<td style=\"width: 33.0232%; height: 18px;\">{<br />&nbsp;&nbsp;&nbsp;&nbsp;\"success\":&nbsp;true,<br />&nbsp;&nbsp;&nbsp;&nbsp;\"data\":&nbsp;{<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"id\":&nbsp;3,<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"title\":&nbsp;\"title3&nbsp;update\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"author\":&nbsp;\"kim\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"password\":&nbsp;\"1234\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"content\":&nbsp;\"content3&nbsp;update\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"createAt\":&nbsp;\"2022-07-28T05:23:32.393+00:00\",<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"modifiedAt\":&nbsp;\"2022-07-28T05:27:19.442+00:00\"<br />&nbsp;&nbsp;&nbsp;&nbsp;}<br />}</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td style=\"width: 8.60469%;\">DELETE</td>\n" +
                "<td style=\"width: 19.0116%;\">/api/boards/{id}</td>\n" +
                "<td style=\"width: 16.8024%;\">특정 게시글 삭제하기</td>\n" +
                "<td style=\"width: 22.5582%;\">-</td>\n" +
                "<td style=\"width: 33.0232%;\">{<br />&nbsp;&nbsp;&nbsp;&nbsp;\"success\":&nbsp;true,<br />&nbsp;&nbsp;&nbsp;&nbsp;\"data\":&nbsp;2<br />}</td>\n" +
                "</tr>\n" +
                "</table>";
    }
}
