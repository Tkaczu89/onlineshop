package sda.kato.product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddProductServlet", value = "/addProduct")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = createNewProductFromRequest(req);

    }

    private Product createNewProductFromRequest(HttpServletRequest req) {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Double price = Double.valueOf(req.getParameter("price"));
        String url = req.getParameter("url");

        return new Product(name, description, price, url);
    }
}
