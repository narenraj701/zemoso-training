package com.example.bookservice.serviceImpl;

import com.example.bookservice.DAO.TopicRepository;
import com.example.bookservice.model.Topic;
import com.example.bookservice.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicRepository topicRepository;
    @Override
    public List<Topic> getTopics() {
        return topicRepository.findAll();
    }
}
