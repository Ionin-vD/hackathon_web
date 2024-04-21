package com.hackathon.hackathon_web.db.entity;

import javax.persistence.*;

@Entity
public class TeamVotedScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JoinColumn(name = "team_id_is_voted")
    private Long teamIdIsVoted;
    @JoinColumn(name = "team_id_voted")
    private Long teamIdVoted;

    private Long scoreDesign;
    private Long scoreUsabilit;
    private Long scoreImplemen;
    private Long scoreGeneral;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamIdIsVoted() {
        return teamIdIsVoted;
    }

    public void setTeamIdIsVoted(Long teamIdIsVoted) {
        this.teamIdIsVoted = teamIdIsVoted;
    }

    public Long getTeamIdVoted() {
        return teamIdVoted;
    }

    public void setTeamIdVoted(Long teamIdVoted) {
        this.teamIdVoted = teamIdVoted;
    }

    public Long getScoreDesign() {
        return scoreDesign;
    }

    public void setScoreDesign(Long scoreDesign) {
        this.scoreDesign = scoreDesign;
    }

    public Long getScoreUsabilit() {
        return scoreUsabilit;
    }

    public void setScoreUsabilit(Long scoreUsabilit) {
        this.scoreUsabilit = scoreUsabilit;
    }

    public Long getScoreImplemen() {
        return scoreImplemen;
    }

    public void setScoreImplemen(Long scoreImplemen) {
        this.scoreImplemen = scoreImplemen;
    }

    public Long getScoreGeneral() {
        return scoreGeneral;
    }

    public void setScoreGeneral(Long scoreGeneral) {
        this.scoreGeneral = scoreGeneral;
    }
}
