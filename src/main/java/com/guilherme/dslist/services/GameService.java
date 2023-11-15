package com.guilherme.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.dslist.dto.GameDTO;
import com.guilherme.dslist.dto.GameMinDTO;
import com.guilherme.dslist.entities.Game;
import com.guilherme.dslist.repositories.GameRepository;

import jakarta.transaction.Transactional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public List<GameMinDTO> findAll() {
        List<Game> result = this.gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional
    public GameDTO findById(Long id) {
        Game result = this.gameRepository.findById(id).get();
        return new GameDTO(result);
    }
}
