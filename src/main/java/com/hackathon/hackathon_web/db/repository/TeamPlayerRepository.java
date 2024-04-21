package com.hackathon.hackathon_web.db.repository;

import com.hackathon.hackathon_web.db.entity.Player;
import com.hackathon.hackathon_web.db.entity.Team;
import com.hackathon.hackathon_web.db.entity.TeamPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamPlayerRepository extends JpaRepository<TeamPlayer, Long> {
    List<TeamPlayer> findByTeam(Team team);
}
