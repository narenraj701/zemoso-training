package com.example.bookservice.serviceImpl;

import com.example.bookservice.DAO.UserBookRepository;
import com.example.bookservice.model.UserStats;
import com.example.bookservice.service.UserStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserStatsServiceImpl implements UserStatsService {
    @Autowired
    UserBookRepository userBookRepository;

    @Override
    public UserStats getUserStats(UUID userId) {
        UserStats userStats=new UserStats();
        userStats.setUserId(userId);
        userStats.setCurrentlyReadingCount(userBookRepository.getCurrentlyReadingCount(userId));
        return userStats;
    }
}
