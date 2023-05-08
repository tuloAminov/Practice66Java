package com.example.practice66bit.services;

import com.example.practice66bit.entity.Player;
import com.example.practice66bit.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class PlayerService {

    private final PlayerRepo playerRepo;

    @Autowired
    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public void save(Player player) {
        playerRepo.save(player);
    }

    public Player findById(Long id) {
        return playerRepo.getReferenceById(id);
    }

    public List<Player> findAll() {
        return playerRepo.findAllByOrderById();
    }

    public List<String> getTeams() {
        List<String> teams = new ArrayList<>();
        List<Player> players = findAll();
        for (Player player : players) {
            if (!teams.contains(player.getTeam()))
                teams.add(player.getTeam());
        }

        return teams;
    }
}
