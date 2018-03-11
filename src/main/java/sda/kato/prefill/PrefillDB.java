package sda.kato.prefill;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sda.kato.product.Product;
import sda.kato.utilities.HibernateUtil;

public class PrefillDB {
    public static void main(String[] args) {
        try (SessionFactory factory = HibernateUtil.getSessionFactory()) {
            try (Session session = factory.openSession()) {
                Transaction trans = null;
                try {
                    trans = session.beginTransaction();
                    String url =
                            "https://beebom-redkapmedia.netdna-ssl.com/wp-content/uploads/2016/01/Reverse-Image-Search-Engines-Apps-And-Its-Uses-2016.jpg";
                    Product product = new Product("mis", "pluszowy mis", 10.00, url);
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


}