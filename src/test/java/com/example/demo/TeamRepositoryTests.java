package com.example.demo;

import com.example.demo.model.Player;
import com.example.demo.model.Team;
import com.example.demo.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TeamRepositoryTests {

    @Autowired
    TeamRepository teamRepository;

    @Test
    void 조회연습() {
        Optional<Team> opt = teamRepository.findById(1L); // Team 1
        Team team = opt.get();
        String teamName = team.getName();
        System.out.println(teamName);

        List<Player> players = team.getPlayers();

        // tostring() 에서 재귀호출 처럼 동작 -> StackOverflow (메모리 부족)
        // team -> player -> team -> player
        System.out.println(players);
    }
}
