package com.khanhhoang.thi_ket_thuc_module_3.controller;
import com.khanhhoang.thi_ket_thuc_module_3.DAO.ProductDAO;
import com.khanhhoang.thi_ket_thuc_module_3.model.Product;
import com.khanhhoang.thi_ket_thuc_module_3.utils.ValidateUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewFormProduct(request, response);
                    break;
                case "update":
                    showEditFormProduct(request, response);
                    break;
                case "delete":
                    showDeleteForm(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createProduct(request, response);
                    break;
                case "update":
                    updateProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> listProduct = productDAO.selectAllProduct();
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/product/product.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/product/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        Product existingProduct = productDAO.selectProductById(id);
        request.setAttribute("product", existingProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/product/update.jsp");
        dispatcher.forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Product newProduct = new Product();
        List<String> errors = new ArrayList<>();
        try {
            String name = request.getParameter("name");
            if (name.trim().equals("")) errors.add("T??n kh??ng ???????c ????? tr???ng");
            newProduct.setName(name);
            String color = request.getParameter("color");
            int price = Integer.parseInt(request.getParameter("price"));
            if (price < 10000 || price > 100000000) errors.add("Gi?? tr??n 10000 d?????i 100000000");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            if (quantity <= 0 || quantity > 10000) errors.add("S??? l?????ng ph???i l???n h??n 0 ho???c b?? h??n 10000");
            String describes = request.getParameter("describes");
            if (describes.trim().equals("")) errors.add("Kh??ng ???????c ????? tr???ng ph???n m?? t???");
            int category =Integer.parseInt(request.getParameter("category")) ;
            if (errors.isEmpty()) {
                Product products = new Product(name, price, quantity, color, describes, category);
                products.setName(name);
                products.setPrice(price);
                products.setQuantity(quantity);
                products.setColor(color);
                products.setDescribes(describes);
                request.setAttribute("message", "Th??m m???i s???n ph???m" + " ' " + name +  "th??nh c??ng");
                request.setAttribute("product", newProduct);
                productDAO.insertProduct(name, price, quantity, color, describes,category);
            }
        }
        catch (NumberFormatException numberFormatException) {
            errors.add("?????nh d???ng c???a gi?? ho???c s??? l?????ng kh??ng h???p l???");
        } finally {
            RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("/WEB-INF/product/create.jsp");
            request.setAttribute("errors", errors);
            requestDispatcher1.forward(request, response);
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String describes = request.getParameter("describes");
        int category = Integer.parseInt(request.getParameter("category_id"));
        try {
                Product products = new Product(id, name, price, quantity, color, describes,category);
                products.setName(name);
                products.setPrice(price);
                products.setQuantity(quantity);
                products.setColor(color);
                products.setDescribes(describes);
                request.setAttribute("message", "S???a m???i s???n ph???m th??nh c??ng");
                productDAO.editProducts(products);
                response.sendRedirect("/product");
            }
        catch (NumberFormatException numberFormatException) {
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/product/update.jsp");
        requestDispatcher.forward(request, response);
    }
    public void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ProductDAO productDAO = new ProductDAO();
        productDAO.deleteProduct(id);
        List<Product> listProduct = productDAO.selectAllProduct();
        req.setAttribute("listProduct", listProduct);
        resp.sendRedirect("/product");
    }

}

