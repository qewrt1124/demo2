package com.example.demo;

import com.example.demo.model.Player;
import com.example.demo.model.Team;
import com.example.demo.repository.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class PlayerRepositoryTests {

    @Autowired
    PlayerRepository playerRepository;

    @Test
    void 조회연습() {

        Optional<Player> opt = playerRepository.findById(1L);
        Player player = opt.get();

        String teamName = player.getTeam().getName();
        System.out.println(teamName);
    }

    @Test
    void 입력연습() {
        Player player = new Player();
        player.setName("Player 1");

        Team team = new Team();
//        team.setName("Team 1");

        team.setId(1L);
        player.setTeam(team);
        playerRepository.save(player);
    }
}
