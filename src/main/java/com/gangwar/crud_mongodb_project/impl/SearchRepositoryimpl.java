package com.gangwar.crud_mongodb_project.impl;

import com.gangwar.crud_mongodb_project.model.Post;
import com.gangwar.crud_mongodb_project.repository.SearchRepository;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryimpl implements SearchRepository {

@Autowired
    MongoClient client;

@Autowired
    MongoConverter mongoConverter;

    @Override
    public List<Post> findbytext(String text) {
      final   List<Post> posts =new ArrayList<>();

        MongoDatabase database = client.getDatabase("Gangwar");
        MongoCollection<Document> collection = database.getCollection("CrudApp");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("skills", "description", "profile")))),
                new Document("$sort",
                        new Document("experience", 1L)),
                new Document("$limit", 2L)));

        result.forEach(document -> posts.add(mongoConverter.read(Post.class,document)));

      return posts;
    }
}
