package com.example.bookservice.service;

import com.example.bookservice.model.UserStats;

import java.util.UUID;

public interface UserStatsService {
    UserStats getUserStats(UUID userId);
}
