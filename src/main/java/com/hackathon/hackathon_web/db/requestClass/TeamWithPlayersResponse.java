package com.hackathon.hackathon_web.db.requestClass;

import com.hackathon.hackathon_web.db.entity.Player;
import com.hackathon.hackathon_web.db.entity.Team;

import java.util.List;

public class TeamWithPlayersResponse {
    private Team team;
    private List<Player> players;

    public TeamWithPlayersResponse(Team team, List<Player> players) {
        this.team = team;
        this.players = players;
    }

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
