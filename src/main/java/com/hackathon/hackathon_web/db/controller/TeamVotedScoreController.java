package com.hackathon.hackathon_web.db.controller;

import com.hackathon.hackathon_web.db.entity.TeamVotedScore;
import com.hackathon.hackathon_web.db.service.TeamVotedScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team_score_voted")
public class TeamVotedScoreController {
    @Autowired
    private TeamVotedScoreService teamVotedScoreService;

    @PostMapping("/add_score")
    public void addScore(@RequestBody TeamVotedScore teamVotedScore) {

    }

    @GetMapping("/get_score_local")
    public TeamVotedScore getScoreLocal(@RequestParam Long teamIdIsVoted, @RequestParam Long teamIdVoted) {
        return teamVotedScoreService.getTeamVotedScore(teamIdIsVoted, teamIdVoted);
    }
}
