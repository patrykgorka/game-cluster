package pl.game.cluster.dao;

import org.springframework.stereotype.Repository;
import pl.game.cluster.entity.Games;
import pl.game.cluster.entity.Status;

import java.util.List;

@Repository
public class GamesDao extends GenericDao<Games> {

    public List getByStatus(Status status){
        startSession();
        List list  = session.createQuery("from Games g where g.status ='" + status + "'").list();
        tx.commit();
        session.close();

        return list;
    }
    public List getByName(String name){
        startSession();
        List list  = session.createQuery("from Games g where g.name ='" + name + "'").list();
        tx.commit();
        session.close();

        return list;
    }
}
