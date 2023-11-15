package com.guilherme.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.dslist.dto.GameDTO;
import com.guilherme.dslist.dto.GameMinDTO;
import com.guilherme.dslist.entities.Game;
import com.guilherme.dslist.projection.GameMinProject;
import com.guilherme.dslist.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> result = this.gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    public GameDTO findById(Long id) {
        Game result = this.gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProject> result = this.gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
