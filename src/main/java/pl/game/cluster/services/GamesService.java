package pl.game.cluster.services;

import pl.game.cluster.entity.Games;
import pl.game.cluster.entity.Status;

import java.util.List;

public interface GamesService {
    public void saveOrUpdate(Games object);
    public void delete(Games object);
    public void deleteById(int id);
    public List getAll();
    public Games getById (int id);
    public List getByStatus(Status status);
}
