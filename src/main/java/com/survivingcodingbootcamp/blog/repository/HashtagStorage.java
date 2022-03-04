package com.survivingcodingbootcamp.blog.repository;

import com.survivingcodingbootcamp.blog.model.Hashtag;

public interface HashtagStorage {
    Iterable<Hashtag> retrieveAllHashtags();
    void save(Hashtag hashtagToAdd);
    Hashtag createOrRetrieveHashtag(String name);
    Hashtag findById(Long id);
    Hashtag findByName(String name);
}
