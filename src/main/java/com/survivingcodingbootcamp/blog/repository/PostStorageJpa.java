package com.survivingcodingbootcamp.blog.repository;

import com.survivingcodingbootcamp.blog.model.Post;

public class PostStorageJpa implements PostStorage{
    private PostRepository postRepo;

    public PostStorageJpa (PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public Iterable<Post> retrieveAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post retrievePostById(long id) {
        return postRepo.findById(id).get();
    }

    @Override
    public void save(Post postToAdd) {
        postRepo.save(postToAdd);
    }
}
