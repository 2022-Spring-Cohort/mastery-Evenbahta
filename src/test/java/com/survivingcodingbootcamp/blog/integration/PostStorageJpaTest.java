package com.survivingcodingbootcamp.blog.integration;

import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.PostStorage;
import com.survivingcodingbootcamp.blog.repository.PostStorageJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PostStorageJpaTest {
    private PostRepository postRepo;
    private PostStorage underTest;
    private Post testPost;

    @BeforeEach
    void setUp() {
        postRepo = mock(PostRepository.class);
        underTest = new PostStorageJpa(postRepo);
        testPost = mock(Post.class);
    }

    @Test
    public void retrieveAllPostsShouldFindAllPostsFromRepo() {
        Iterable<Post> posts = Collections.singletonList(testPost);
        when(postRepo.findAll()).thenReturn(posts);
        assertThat(underTest.retrieveAllPosts()).contains(testPost);
    }

    @Test
    public void retrievePostByIdShouldFindPostFromRepo() {
        when(postRepo.findById(1L)).thenReturn(Optional.of(testPost));
        Post retrievedPost = underTest.retrievePostById(1L);
        assertThat(retrievedPost).isEqualTo(testPost);
    }

    @Test
    public void saveShouldSavePostToRepo() {
        underTest.save(testPost);
        verify(postRepo).save(testPost);
    }


}