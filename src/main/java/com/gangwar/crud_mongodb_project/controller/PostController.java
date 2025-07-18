package com.gangwar.crud_mongodb_project.controller;


import com.gangwar.crud_mongodb_project.repository.PostRepository;
import com.gangwar.crud_mongodb_project.model.Post;
import com.gangwar.crud_mongodb_project.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    SearchRepository searchRepository;

    @GetMapping("/")
    public String hello() {
        return "Server is up!";
    }

    @GetMapping("/posts")
    public List<Post> getallposts(){

return  postRepository.findAll();

    }

    @GetMapping("posts/{text}")
    public List<Post> searchPost(@PathVariable String text){
        return searchRepository.findbytext(text);
    }


    @PostMapping("/post")
    public  Post createpost(@RequestBody Post post){
       return postRepository.save(post);

    }
}
