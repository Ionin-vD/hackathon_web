package com.hackathon.hackathon_web.db.service;

import com.hackathon.hackathon_web.db.entity.Player;
import com.hackathon.hackathon_web.db.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        Optional<Player> playerOptional = playerRepository.findById(id);
        return playerOptional.orElse(null);
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

}
