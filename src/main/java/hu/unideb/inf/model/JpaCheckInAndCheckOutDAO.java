package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaCheckInAndCheckOutDAO implements CheckInAndCheckOutDAO{
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveCheckInAndCheckOut(CheckInAndCheckOut a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteCheckInAndCheckOut(CheckInAndCheckOut a) {
        entityManager.getTransaction().begin();
        entityManager.remove(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateCheckInAndCheckOut(CheckInAndCheckOut a) {
        saveCheckInAndCheckOut(a);
    }

    @Override
    public List<CheckInAndCheckOut> getCheckInAndCheckOut() {
        TypedQuery<CheckInAndCheckOut> query = entityManager.createQuery(
                "SELECT a FROM CheckInAndCheckOut a", CheckInAndCheckOut.class);
        List<CheckInAndCheckOut> CheckInAndCheckOuts = query.getResultList();
        return CheckInAndCheckOuts;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
