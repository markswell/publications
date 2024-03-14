package com.markswell.publications.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.markswell.publications.domain.Comment;
import com.markswell.publications.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RedisServiceImpl implements RedisService {

    private static final String KEY = "Comment";

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public void save(List<Comment> comments, String id) {
        redisTemplate.opsForHash().put(KEY, id, comments);
    }

    @Override
    public List<Comment> findById(String id) {
        return (List<Comment>) redisTemplate.opsForHash().get(KEY, id);
    }

}
