package com.survivingcodingbootcamp.blog.repository;

import com.survivingcodingbootcamp.blog.model.Topic;
import org.springframework.stereotype.Service;

@Service
public class TopicStorageJpa implements TopicStorage {
    private TopicRepository topicRepo;

    public TopicStorageJpa(TopicRepository topicRepo) {

    this.topicRepo =topicRepo;
}
    @Override
    public Iterable<Topic> retrieveAllTopics() {
        return topicRepo.findAll();
    }

    @Override
    public void save(Topic topicToSave) {
     topicRepo.save(topicToSave);
    }

    @Override
    public Topic retrieveSingleTopic(long id) {
        return topicRepo.findById(id).get();
    }

    @Override
    public boolean topicExists(String name) {
        if(topicRepo.findByName(name)!= null){
            return true;
        }
        return false;
    }
}
