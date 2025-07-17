package com.gangwar.crud_mongodb_project.repository;

import com.gangwar.crud_mongodb_project.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public  interface PostRepository extends MongoRepository<Post,String> {
}
