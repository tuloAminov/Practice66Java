package com.example.practice66bit.controllers;

import com.example.practice66bit.entity.Player;
import com.example.practice66bit.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    private final PlayerService playerService;

    @Autowired
    public MainController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @ModelAttribute("players")
    public List<Player> allPlayers() {
        return playerService.findAll();
    }

    @ModelAttribute("teams")
    public List<String> getTeams() {
        return playerService.getTeams();
    }

    @GetMapping("/add")
    public String addPlayerPage(Model model) {
        model.addAttribute("player", new Player());
        return "addPlayer";
    }

    @PostMapping("/add")
    public String addPlayer(Player player, Model model) {
        model.addAttribute("player", player);
        playerService.save(player);
        return "redirect:/all";
    }

    @GetMapping("/all")
    public String getAllPlayers(Player player, Model model) {
        model.addAttribute("playerToUpdate", player);
        return "allPlayers";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("playerToUpdate", playerService.findById(id));
        return "updatePlayer";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("playerToUpdate") Player player) {
        player.setId(id);
        player.setCountry(playerService.findById(id).getCountry());
        playerService.save(player);
        return "redirect:/all";
    }
}
