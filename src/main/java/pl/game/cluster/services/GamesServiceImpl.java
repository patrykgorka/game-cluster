package pl.game.cluster.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.game.cluster.dao.GamesDao;
import pl.game.cluster.entity.Status;
import pl.game.cluster.entity.Games;

import java.util.Collections;
import java.util.List;

@Service
public class GamesServiceImpl implements GamesService {

    @Autowired
    private GamesDao gameDao;

    @Override
    public void saveOrUpdate(Games game) {
        gameDao.saveOrUpdate(game);
    }

    @Override
    public void delete(Games game) {
        gameDao.delete(game);
    }

    @Override
    public void deleteById(int id) {
        gameDao.deleteById(Games.class , id);
    }

    @Override
    public List getAll() {
        List list = gameDao.getAll(Games.class);
        Collections.sort(list);
        return list;
    }

    @Override
    public Games getById(int id) {
        return gameDao.getById(Games.class , id);
    }

    @Override
    public List getByStatus(Status status){
        return gameDao.getByStatus(status);
    }
}