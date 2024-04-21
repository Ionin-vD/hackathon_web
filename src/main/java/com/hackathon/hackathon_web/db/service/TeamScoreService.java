package com.hackathon.hackathon_web.db.service;

import com.hackathon.hackathon_web.db.entity.Team;
import com.hackathon.hackathon_web.db.entity.TeamScore;
import com.hackathon.hackathon_web.db.repository.TeamScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamScoreService {
    @Autowired
    private TeamScoreRepository teamScoreRepository;

    public List<TeamScore> getAllTeams() {
        return teamScoreRepository.findAll();
    }

    public TeamScore getTeamById(Long id) {
        return teamScoreRepository.findById(id).orElse(null);
    }

    public TeamScore save(TeamScore teamScore) {
        return teamScoreRepository.save(teamScore);
    }
}
