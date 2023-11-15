package com.guilherme.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PositionPK {

    @ManyToOne
    @JoinColumn(name = "game_list_id")
    private GameList gameList;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    public PositionPK() {
    }

    public PositionPK(GameList gameList, Game game) {
        this.gameList = gameList;
        this.game = game;
    }

    public GameList getGameList() {
        return gameList;
    }

    public void setGameList(GameList gameList) {
        this.gameList = gameList;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gameList == null) ? 0 : gameList.hashCode());
        result = prime * result + ((game == null) ? 0 : game.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PositionPK other = (PositionPK) obj;
        if (gameList == null) {
            if (other.gameList != null)
                return false;
        } else if (!gameList.equals(other.gameList))
            return false;
        if (game == null) {
            if (other.game != null)
                return false;
        } else if (!game.equals(other.game))
            return false;
        return true;
    }

}
