package com.hackathon.hackathon_web.db.service;

import com.hackathon.hackathon_web.db.entity.TeamPlayer;
import com.hackathon.hackathon_web.db.repository.TeamPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamPlayerService {

    private final TeamPlayerRepository teamPlayerRepository;

    @Autowired
    public TeamPlayerService(TeamPlayerRepository teamPlayerRepository) {
        this.teamPlayerRepository = teamPlayerRepository;
    }

    public void saveTeamPlayer(TeamPlayer teamPlayer) {
        teamPlayerRepository.save(teamPlayer);
    }

}

