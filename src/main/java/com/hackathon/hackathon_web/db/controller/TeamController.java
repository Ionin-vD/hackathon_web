package com.hackathon.hackathon_web.db.controller;

import com.hackathon.hackathon_web.db.entity.Player;
import com.hackathon.hackathon_web.db.entity.Team;
import com.hackathon.hackathon_web.db.entity.TeamPlayer;
import com.hackathon.hackathon_web.db.requestClass.TeamAndPlayersRequest;
import com.hackathon.hackathon_web.db.requestClass.TeamWithPlayersResponse;
import com.hackathon.hackathon_web.db.service.PlayerService;
import com.hackathon.hackathon_web.db.service.TeamPlayerService;
import com.hackathon.hackathon_web.db.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamPlayerService teamPlayerService;

    @GetMapping("/get_all")
    public List<TeamWithPlayersResponse> getAllTeams() {
        List<Team> teams = teamService.getAllTeams();
        List<TeamWithPlayersResponse> teamResponses = new ArrayList<>();

        for (Team team : teams) {
            List<Player> players = teamService.getPlayersByTeam(team);
            TeamWithPlayersResponse response = new TeamWithPlayersResponse(team, players);
            teamResponses.add(response);
        }

        return teamResponses;
    }

    @PostMapping("/add_team")
    public ResponseEntity<String> addTeamAndPlayers(@RequestBody TeamAndPlayersRequest request) {
        Team team = request.getTeam();
        List<Player> players = request.getPlayers();

        if (team == null || players == null || players.isEmpty()) {
            return ResponseEntity.badRequest().body("Team or Players information missing");
        }

        // Save team
        teamService.saveTeam(team);

        // Save players and associate them with the team
        for (Player player : players) {
            playerService.savePlayer(player);
            TeamPlayer teamPlayer = new TeamPlayer();
            teamPlayer.setTeam(team);
            teamPlayer.setPlayer(player);
            teamPlayerService.saveTeamPlayer(teamPlayer);
        }

        return ResponseEntity.ok("Team and Players added successfully");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TeamWithPlayersResponse> getTeamById(@PathVariable Long id) {
        Team team = teamService.getTeamById(id);
        if (team == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Player> players = teamService.getPlayersByTeam(team);
        TeamWithPlayersResponse response = new TeamWithPlayersResponse(team, players);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTeam(@PathVariable Long id, @RequestBody Team updatedTeam) {
        Team existingTeam = teamService.getTeamById(id);
        if (existingTeam == null) {
            return ResponseEntity.notFound().build();
        }

        //existingTeam.setTitle(updatedTeam.getTitle());
        existingTeam.setImageUrl(updatedTeam.getImageUrl());
        //existingTeam.setLogin(updatedTeam.getLogin());
        //existingTeam.setPassword(updatedTeam.getPassword());
        //existingTeam.setEmail(updatedTeam.getEmail());

        teamService.saveTeam(existingTeam);

        return ResponseEntity.ok("Team updated successfully");
    }

    @PostMapping("/check_auth")
    public ResponseEntity<TeamWithPlayersResponse> checkAuth(@RequestBody Map<String, Object> requestData) {
        String providedLogin = (String) requestData.get("login");
        String providedPassword = (String) requestData.get("password");

        // Проверяем, что данные о логине и пароле были предоставлены
        if (providedLogin != null && providedPassword != null) {
            // Получаем все команды из базы данных
            List<TeamWithPlayersResponse> allTeams = getAllTeams();

            // Перебираем все команды и проверяем логин и пароль
            for (TeamWithPlayersResponse teamFromDB : allTeams) {
                if (teamFromDB.getTeam().getLogin().equals(providedLogin) && teamFromDB.getTeam().getPassword().equals(providedPassword)) {
                    // Если логин и пароль совпадают, возвращаем информацию о команде и игроках
                    TeamWithPlayersResponse response = new TeamWithPlayersResponse(teamFromDB.getTeam(), teamFromDB.getPlayers());
                    return ResponseEntity.ok(response);
                }
            }
        }

        // Если не найдено совпадений или данные не были предоставлены, возвращаем ошибку
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
}

