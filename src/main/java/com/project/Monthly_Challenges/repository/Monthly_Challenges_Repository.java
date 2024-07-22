package com.project.Monthly_Challenges.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Monthly_Challenges.entity.Monthly_Challenges;
@Repository
public interface Monthly_Challenges_Repository extends JpaRepository<Monthly_Challenges,Long> {
    List<Monthly_Challenges> findByMonth(String month);


}
