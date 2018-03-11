package sda.kato.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProductRepository {

    public List<Product> getAll(SessionFactory factory) {
        try (Session session = factory.openSession()) {
            Query<Product> q = session.createQuery("FROM Product");
            return q.getResultList();
        }
    }

    public void add(Product product, SessionFactory factory) {
        try (Session session = factory.openSession()) {
            Transaction trans = null;
            try {
                trans = session.beginTransaction();
                session.save(product);
                trans.commit();
            } catch (RuntimeException e) {
                if (trans != null) {
                    trans.rollback();
                    e.printStackTrace();
                }
            }
        }
    }
}
