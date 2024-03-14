package com.markswell.publications.service;

import com.markswell.publications.domain.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getComments(String id);

}
