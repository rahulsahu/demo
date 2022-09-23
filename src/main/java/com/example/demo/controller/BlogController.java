package com.example.demo.controller;

import com.example.demo.domain.Blog;
import com.example.demo.repository.BlogRepository;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping(path = "/blog")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping(value = "/status",produces = MediaType.APPLICATION_JSON_VALUE)
    public String testService(){
        return "Up and Running";
    }

    @PostMapping(value = "/create")
    public ResponseEntity createBlog(Blog blog){
        blogRepository.createBlog(blog);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public Flux<Blog> getBlog(@PathVariable String id){
        Flux<Blog> blog = Flux.just(blogRepository.getBlog(id));
        return blog;
    }

    @GetMapping(value = "/list",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Blog> getBlogs(){
        return Flux.fromStream(blogRepository.getBlogs().stream()).delayElements(Duration.ofSeconds(1));
    }
}
