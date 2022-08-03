package com.sparta.week02.controller;

import com.sparta.week02.dto.ResponseDto;
import com.sparta.week02.model.Comment;
import com.sparta.week02.security.UserDetailsImpl;
import com.sparta.week02.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentService commentService;

    @PostMapping("/api/{boardId}/comment")
    public ResponseDto<Comment> write(@PathVariable int boardId,
                                      @RequestBody Comment comment,
                                      @AuthenticationPrincipal UserDetailsImpl userDetails){
        return new ResponseDto<>("SUCCESS", commentService.save(boardId, comment, userDetails.getUser()));

    }

    @GetMapping("/board/comment")
    public List<Comment> getComment(){
        return commentService.getComment();
    }

    @PutMapping("/api/comment/{commentId}")
    public ResponseDto<Comment> updateComment(@PathVariable int commentId,
                                 @RequestBody Comment comment,
                                 @AuthenticationPrincipal UserDetailsImpl userDetails){
        Comment cmt = commentService.updateComment( commentId, comment, userDetails.getUser());
        return new ResponseDto<>("SUCCESS", cmt);

    }

    @DeleteMapping("/api/comment/{commentId}")
    public ResponseDto<String> deleteBoard(@PathVariable int commentId,
                                           @AuthenticationPrincipal UserDetailsImpl userDetails){
        int id = commentService.deleteComment(commentId, userDetails.getUser());
        String message = " Comment " + id + " Delete SUCCESS";
        return new ResponseDto<>("SUCCESS", message);
    }
}
