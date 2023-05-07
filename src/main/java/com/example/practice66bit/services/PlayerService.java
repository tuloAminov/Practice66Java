package com.example.practice66bit.services;

import com.example.practice66bit.entity.Player;
import com.example.practice66bit.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private PlayerRepo playerRepo;

    @Autowired
    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public void addPlayer(Player player) {
        playerRepo.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepo.findAll();
    }

    public List<String> getTeams() {
        List<String> teams = new ArrayList<>();
        List<Player> players = getAllPlayers();
        for (Player player : players) {
            if (!teams.contains(player.getTeam()))
                teams.add(player.getTeam());
        }

        return teams;
    }
}
