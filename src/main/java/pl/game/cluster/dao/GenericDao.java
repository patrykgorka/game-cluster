package pl.game.cluster.dao;

import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public abstract class GenericDao<T> implements Dao<T> {

    @Autowired
    protected SessionFactory sessionFactory;
    protected Session session;
    protected Transaction tx;

    protected void startSession() throws HibernateError {
        session = this.sessionFactory.openSession();
        tx = this.session.beginTransaction();
    }

    public void saveOrUpdate(T object) {
        startSession();
        session.saveOrUpdate(object);
        tx.commit();
        session.close();
    }

    public void delete(T object) {
        startSession();
        session.delete(object);
        tx.commit();
        session.close();
    }

    public void deleteById(Class classs , int id){
        startSession();
        Object object = session.get(classs,id);
        session.delete(object);
        tx.commit();
        session.close();

    }
    public List getAll(Class classs){
        startSession();
        List list  = session.createQuery("from " + classs.getName()).list();
        tx.commit();
        session.close();

        return list;
    }

    public T getById(Class classs , int id){

        startSession();
        Object object = session.load(classs, id);
        tx.commit();
        session.close();

        return (T)object;
    }
}