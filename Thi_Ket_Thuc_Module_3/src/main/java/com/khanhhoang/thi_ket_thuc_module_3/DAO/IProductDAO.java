package com.khanhhoang.thi_ket_thuc_module_3.DAO;

import com.khanhhoang.thi_ket_thuc_module_3.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    List<Product> selectAllProduct();

    Product selectProductById(int id);

    void insertProduct(String name, int price, int quantity, String color, String describes, int category_id) throws SQLException;

    boolean deleteProduct(int id) throws SQLException;

    boolean editProducts(Product products) throws SQLException;

    List<Product> searchByName(String txtSearch);
    public boolean checkNameExits(String name);
}
