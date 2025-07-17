package com.gangwar.crud_mongodb_project.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "CrudApp")
public class Post {


    private String description;
    private int experience;
    private String profile;
    private String skills[];

    public Post() {
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Post{" +
                "description='" + description + '\'' +
                ", experience=" + experience +
                ", profile='" + profile + '\'' +
                ", skills=" + Arrays.toString(skills) +
                '}';
    }
}
