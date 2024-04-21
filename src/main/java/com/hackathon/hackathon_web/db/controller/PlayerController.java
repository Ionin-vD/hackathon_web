package com.hackathon.hackathon_web.db.controller;

import com.hackathon.hackathon_web.db.entity.Player;
import com.hackathon.hackathon_web.db.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/get_all")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Player player = playerService.getPlayerById(id);
        if (player == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player savedPlayer = playerService.savePlayer(player);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePlayer(@PathVariable Long id, @RequestBody Player updatedPlayer) {
        Player existingPlayer = playerService.getPlayerById(id);
        if (existingPlayer == null) {
            return ResponseEntity.notFound().build();
        }

        existingPlayer.setName(updatedPlayer.getName());
        existingPlayer.setSerName(updatedPlayer.getSerName());
        existingPlayer.setPatronymic(updatedPlayer.getPatronymic());
        existingPlayer.setImageUrl(updatedPlayer.getImageUrl());
        existingPlayer.setStack(updatedPlayer.getStack());

        playerService.savePlayer(existingPlayer);

        return ResponseEntity.ok("Player updated successfully");
    }

}
