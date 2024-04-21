package com.hackathon.hackathon_web.db.repository;

import com.hackathon.hackathon_web.db.entity.TeamVotedScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamVotedScoreRepository extends JpaRepository<TeamVotedScore, Long> {
    TeamVotedScore findFirstByTeamIdIsVotedAndTeamIdVoted(Long teamIdIsVoted, Long teamIdVoted);
}
