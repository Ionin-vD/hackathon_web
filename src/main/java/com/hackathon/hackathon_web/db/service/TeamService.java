package com.hackathon.hackathon_web.db.service;

import com.hackathon.hackathon_web.db.entity.Player;
import com.hackathon.hackathon_web.db.entity.Team;
import com.hackathon.hackathon_web.db.entity.TeamPlayer;
import com.hackathon.hackathon_web.db.repository.TeamPlayerRepository;
import com.hackathon.hackathon_web.db.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamPlayerRepository teamPlayerRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<Player> getPlayersByTeam(Team team) {
        List<TeamPlayer> teamPlayers = teamPlayerRepository.findByTeam(team);
        return teamPlayers.stream().map(TeamPlayer::getPlayer).collect(Collectors.toList());
    }
}
