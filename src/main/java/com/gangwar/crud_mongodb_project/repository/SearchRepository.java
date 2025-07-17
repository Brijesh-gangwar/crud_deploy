package com.gangwar.crud_mongodb_project.repository;

import com.gangwar.crud_mongodb_project.model.Post;

import java.util.List;

public interface SearchRepository {

    List<Post> findbytext(String  text);
}
