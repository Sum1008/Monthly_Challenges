package com.project.Monthly_Challenges.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Monthly_Challenges.Monthly_Challenges_Services.Monthly_Challenges_Service;
import com.project.Monthly_Challenges.entity.Monthly_Challenges;

@RestController
@RequestMapping("/challenges")
public class Monthly_Challenges_Controller {
    @Autowired
    private Monthly_Challenges_Service monthly_Challenges_Service;

    @GetMapping
    public List<Monthly_Challenges> getAllChallenges() {
        return monthly_Challenges_Service.getAllChallenges();
    }

    @GetMapping("/{month}")
    public List<Monthly_Challenges> getChallengesByMonth(@PathVariable String month) {
        return monthly_Challenges_Service.getChallengesByMonth(month);
    }

    @PostMapping
    public Monthly_Challenges createChallenge(@RequestBody Monthly_Challenges challenge) {
        return monthly_Challenges_Service.createChallenge(challenge);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monthly_Challenges> updateChallenge(@PathVariable Long id, @RequestBody Monthly_Challenges challengeDetails) {
        Monthly_Challenges updatedChallenge = monthly_Challenges_Service.updateChallenge(id, challengeDetails);
        return ResponseEntity.ok(updatedChallenge);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChallenge(@PathVariable Long id) {
        monthly_Challenges_Service.deleteChallenge(id);
        return ResponseEntity.noContent().build();
    }
}