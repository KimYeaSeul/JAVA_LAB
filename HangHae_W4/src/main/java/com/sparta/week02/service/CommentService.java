package com.sparta.week02.service;

import com.sparta.week02.handler.CustomException;
import com.sparta.week02.handler.ErrorResponse;
import com.sparta.week02.model.Board;
import com.sparta.week02.model.Comment;
import com.sparta.week02.model.Users;
import com.sparta.week02.repository.BoardRepository;
import com.sparta.week02.repository.CommentRepository;
import com.sparta.week02.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    @Transactional
    public Comment save(int boardId, Comment comment, Users user) {

        Board requestBoard = boardRepository.findById(boardId)
                .orElseThrow(()->{
                    throw new CustomException(ErrorResponse.NOT_FOUND_BOARD);
                });
        Comment reqComment = Comment.builder()
                        .content(comment.getContent())
                        .title(comment.getTitle())
                        .author(user)
                        .board(requestBoard)
                        .build();
        return commentRepository.save(reqComment);

    }
    @Transactional(readOnly = false)
    public List<Comment> getComment() {
        return commentRepository.findAll();
    }

    @Transactional
    public Comment updateComment(int id, Comment comment, Users user){
        Comment resComment = commentRepository.findById(id).orElseThrow(
                ()-> new CustomException(ErrorResponse.NOT_FOUND_BOARD));

        if(resComment.getAuthor().getUsername().equals(user.getUsername())){
            resComment.update(comment.getTitle(), comment.getContent());
            return resComment;
        }else{
            throw new CustomException(ErrorResponse.NOT_MATCH_USER);
        }
    }
    @Transactional
    public int deleteComment(int id, Users user) {
        Comment delBoard = commentRepository.findById(id).orElseThrow(
                ()-> new CustomException(ErrorResponse.NOT_FOUND_COMMENT));
        if(delBoard.getAuthor().getUsername().equals(user.getUsername())){
            commentRepository.deleteById(id);
            return id;
        }else{
            throw new CustomException(ErrorResponse.NOT_MATCH_USER);
        }
    }
}
