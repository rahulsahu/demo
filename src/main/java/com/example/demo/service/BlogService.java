package com.example.demo.service;

import com.example.demo.domain.Blog;

import java.util.List;

public interface BlogService {
    void createBlog(Blog blog);
    Blog getBlog(int id);
    List<Blog> getBlogs();
}
