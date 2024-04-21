package com.hackathon.hackathon_web.db.entity;

import javax.persistence.*;

@Entity
public class TeamScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "team_id")
    private Long idTeam;

    private Long scoreDesign;
    private Long scoreUsability;
    private Long scoreImplementation;
    private Long scoreGeneral;
    private Long countNumber;

    public Long getId() {
        return id;   
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScoreDesign() {
        return scoreDesign;
    }

    public void setScoreDesign(Long scoreDesign) {
        this.scoreDesign = scoreDesign;
    }

    public Long getScoreUsability() {
        return scoreUsability;
    }

    public void setScoreUsability(Long scoreUsability) {
        this.scoreUsability = scoreUsability;
    }

    public Long getScoreImplementation() {
        return scoreImplementation;
    }

    public void setScoreImplementation(Long scoreImplementation) {
        this.scoreImplementation = scoreImplementation;
    }

    public Long getScoreGeneral() {
        return scoreGeneral;
    }

    public void setScoreGeneral(Long scoreGeneral) {
        this.scoreGeneral = scoreGeneral;
    }

    public Long getCountNumber() {
        return countNumber;
    }

    public void setCountNumber(Long countNumber) {
        this.countNumber = countNumber;
    }

    public Long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Long idTeam) {
        this.idTeam = idTeam;
    }
}
