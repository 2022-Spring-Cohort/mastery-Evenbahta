package com.survivingcodingbootcamp.blog.integration;

import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import com.survivingcodingbootcamp.blog.repository.TopicStorage;
import com.survivingcodingbootcamp.blog.repository.TopicStorageJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class TopicStorageJpaTest {
    private TopicRepository topicRepo;
    private TopicStorage underTest;
    private Topic testTopic;

    @BeforeEach
    void setUp() {
        topicRepo = mock(TopicRepository.class);
        underTest = new TopicStorageJpa(topicRepo);
        testTopic = new Topic("Testing");
    }

    @Test
    public void retrieveAllTopicsShouldFindAllTopicsFromRepo() {
        List<Topic> retrievedTopics = Collections.EMPTY_LIST;
        when(topicRepo.findAll()).thenReturn(retrievedTopics);

        assertThat(underTest.retrieveAllTopics()).isEmpty();
        verify(topicRepo).findAll();
    }

    @Test
    public void saveShouldSaveTopicToRepo() {
        underTest.save(testTopic);
        verify(topicRepo).save(testTopic);
    }

    @Test
    public void retrieveSingleTopicShouldRetrieveSingleTopicByIdFromRepo() {
        when(topicRepo.findById(1L)).thenReturn(Optional.of(testTopic));
        assertThat(underTest.retrieveSingleTopic(1)).isEqualTo(testTopic);
    }
}
