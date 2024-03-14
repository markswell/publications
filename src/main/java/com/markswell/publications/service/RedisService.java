package com.markswell.publications.service;

import com.markswell.publications.domain.Comment;

import java.util.List;

public interface RedisService {
    void save(List<Comment> comments, String id);

    List<Comment> findById(String id);
}
