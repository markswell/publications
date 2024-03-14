package com.markswell.publications.service.impl;

import com.markswell.publications.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.markswell.publications.domain.Comment;
import com.markswell.publications.client.CommentClient;
import com.markswell.publications.service.CommentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentClient client;
    private final RedisService redisService;

    @Override
    @CircuitBreaker(name = "comments", fallbackMethod = "getCommentsFallback")
    public List<Comment> getComments(String id) {
        var comments = client.getComments(id);
        redisService.save(comments, id);
        return comments;
    }

    private List<Comment> getCommentsFallback(String id, Throwable cause){
        log.warn("[WARNING] fallback with id {}", id);
        return redisService.findById(id);
    }

}
