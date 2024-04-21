package com.hackathon.hackathon_web.db.service;

import com.hackathon.hackathon_web.db.entity.TeamVotedScore;
import com.hackathon.hackathon_web.db.repository.TeamVotedScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamVotedScoreService {
    @Autowired
    private TeamVotedScoreRepository teamVotedScoreRepository;

    public TeamVotedScore getTeamVotedScore(Long teamIdIsVoted, Long teamIdVoted) {
        return teamVotedScoreRepository.findFirstByTeamIdIsVotedAndTeamIdVoted(teamIdIsVoted, teamIdVoted);
    }
}
