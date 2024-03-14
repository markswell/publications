package com.markswell.publications.client;

import com.markswell.publications.domain.Comment;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient(name = "CommentClient", url = "${client.comments.url}")
public interface CommentClient {

//    @CircuitBreaker(name = "interface_test")
    @GetMapping("/comments/{publicationId}")
    List<Comment> getComments(@PathVariable("publicationId") String publicationId);

}
