package com.example.bookservice.DAO;

import com.example.bookservice.model.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UserBookRepository extends JpaRepository<UserBook, UUID> {
    @Query(value = "select count(*) from UserBook where status=1 and user_id=?1" )
    int getCurrentlyReadingCount(UUID userId);
    @Query(value = "select count (*) from UserBook where status=2 and user_id=?1" )
    int getBooksToReadCount(UUID userId);
    @Query(value = "select count (*) from UserBook where status=3 and user_id=?1" )
    int getBooksReadCount(UUID userId);
}
