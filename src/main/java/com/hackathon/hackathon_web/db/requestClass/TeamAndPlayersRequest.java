package com.hackathon.hackathon_web.db.requestClass;

import com.hackathon.hackathon_web.db.entity.Player;
import com.hackathon.hackathon_web.db.entity.Team;

import java.util.List;

public class TeamAndPlayersRequest {
    private Team team;
    private List<Player> players;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
