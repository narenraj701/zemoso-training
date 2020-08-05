package com.example.bookservice.controller;

import com.example.bookservice.DAO.UserBookRepository;
import com.example.bookservice.model.UserStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user-stats")
public class UserStatsController {
    @Autowired
    UserBookRepository userBookRepository;
    @GetMapping("")
    UserStats getUserStats(){
        UUID userid=UUID.fromString("807c1834-d66c-11ea-87d0-0242ac130003");
        UserStats userStats=new UserStats();
        userStats.setUserId(userid);
        userStats.setCurrentlyReadingCount(userBookRepository.getCurrentlyReadingCount(userid));
        userStats.setBooksToReadCount(userBookRepository.getBooksToReadCount(userid));
        userStats.setBooksReadCount(userBookRepository.getBooksReadCount(userid));
        userStats.setTargetCount(100);
        return userStats;
    }
}
