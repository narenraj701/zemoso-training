package com.example.bookservice.controller;

import com.example.bookservice.model.Topic;
import com.example.bookservice.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class topicController {
    @Autowired
    TopicService topicService;
    @GetMapping("")
    public List<Topic> getTopics(){
        return topicService.getTopics();
    }
}
