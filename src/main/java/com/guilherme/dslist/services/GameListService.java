package com.guilherme.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.dslist.dto.GameListDTO;
import com.guilherme.dslist.entities.GameList;
import com.guilherme.dslist.repositories.GameListRepository;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    public List<GameListDTO> findAll() {
        List<GameList> result = this.gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
