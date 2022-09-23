package com.example.demo.repository;

import com.example.demo.domain.Auther;
import com.example.demo.domain.Blog;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BlogRepositoryImpl implements BlogRepository, InitializingBean {

    Map<String,Blog> blogs = new HashMap<>();

    @Override
    public void createBlog(Blog blog) {
        blogs.put(blog.getId(),blog);
    }

    @Override
    public Blog getBlog(String id) {
        return blogs.get(id);
    }

    @Override
    public List<Blog> getBlogs() {
        return blogs.values().stream().collect(Collectors.toList());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for(int i=1;i<=50;i++){
            Blog blog = new Blog(i+" blog",new Auther(i+" Name"));
            blogs.put(blog.getId(),blog);
        };
    }
}
