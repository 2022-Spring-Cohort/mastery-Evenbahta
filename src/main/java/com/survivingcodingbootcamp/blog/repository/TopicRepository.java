package com.survivingcodingbootcamp.blog.repository;

import com.survivingcodingbootcamp.blog.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Long> {
    public Topic findByName(String name);


}
