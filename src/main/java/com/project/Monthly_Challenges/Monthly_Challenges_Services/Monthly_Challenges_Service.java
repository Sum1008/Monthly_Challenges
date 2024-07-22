package com.project.Monthly_Challenges.Monthly_Challenges_Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Monthly_Challenges.entity.Monthly_Challenges;
import com.project.Monthly_Challenges.repository.Monthly_Challenges_Repository;
@Service
public class Monthly_Challenges_Service {

    @Autowired
    private Monthly_Challenges_Repository monthly_Challenges_Repository;

    public List<Monthly_Challenges> getAllChallenges(){
        return monthly_Challenges_Repository.findAll();
    }

    public List<Monthly_Challenges> getChallengesByMonth(String month) {
        return monthly_Challenges_Repository.findByMonth(month);
    }

    public Optional<Monthly_Challenges> getChallengeById(Long id) {
        return monthly_Challenges_Repository.findById(id);
    }

    public Monthly_Challenges createChallenge(Monthly_Challenges challenge) {
        return monthly_Challenges_Repository.save(challenge);
    }

    public Monthly_Challenges updateChallenge(Long id, Monthly_Challenges challengeDetails) {
        Monthly_Challenges challenge = monthly_Challenges_Repository.findById(id).orElseThrow(() -> new RuntimeException("Challenge not found"));
        challenge.setMonth(challengeDetails.getMonth());
        challenge.setDescription(challengeDetails.getDescription());
        return monthly_Challenges_Repository.save(challenge);
    }

    public void deleteChallenge(Long id) {
        monthly_Challenges_Repository.deleteById(id);
    }


}
