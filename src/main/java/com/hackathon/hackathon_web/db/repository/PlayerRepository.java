package com.hackathon.hackathon_web.db.repository;

import com.hackathon.hackathon_web.db.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
