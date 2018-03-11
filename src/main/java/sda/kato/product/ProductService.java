package sda.kato.product;

import org.hibernate.SessionFactory;

import java.util.List;

public class ProductService {
    private ProductRepository repository = new ProductRepository();

    public List<Product> getAll(SessionFactory factory) {
        return repository.getAll(factory);
    }

    public void add(Product product, SessionFactory factory) {
        repository.add(product, factory);
    }
}
