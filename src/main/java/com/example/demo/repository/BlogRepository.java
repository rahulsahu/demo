package com.example.demo.repository;

import com.example.demo.domain.Blog;

import java.util.List;

public interface BlogRepository {
    void createBlog(Blog blog);
    Blog getBlog(String id);
    List<Blog> getBlogs();
}
