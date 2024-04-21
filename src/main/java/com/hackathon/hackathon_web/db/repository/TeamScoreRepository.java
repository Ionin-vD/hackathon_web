package com.hackathon.hackathon_web.db.repository;

import com.hackathon.hackathon_web.db.entity.TeamScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamScoreRepository extends JpaRepository<TeamScore, Long> {
}
