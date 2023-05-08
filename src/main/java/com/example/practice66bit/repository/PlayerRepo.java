package com.example.practice66bit.repository;

import com.example.practice66bit.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepo extends JpaRepository<Player, Long> {
    List<Player> findAllByOrderById();
}