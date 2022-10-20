package com.khanhhoang.thi_ket_thuc_module_3.DAO;

import com.khanhhoang.thi_ket_thuc_module_3.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends DatabaseQuery implements IProductDAO {
    private static final String SELECT_ALL_PRODUCT = "SELECT * FROM sanpham;";
    private static final String INSERT_PRODUCT = "insert into  sanpham (sp_name, sp_price,  sp_quantity ,sp_color ,sp_describes, category_id ) values(?,?,?,?,?,?);";
    private static final String DELETE_PRODUCT = "delete from sanpham where id = ?";
    private static final String UPDATE_PRODUCT = "update sanpham set sp_name = ?, sp_price = ?,  sp_quantity = ? ,sp_color = ? ,sp_describes = ?, category_id = ? where id = ?";
    private static final String SEARCH_PRODUCT_BY_NAME = "select * from sanpham where sp_name like ?";
    private static final String SELECT_PRODUCT_BY_ID = "select sp_name, sp_price,  sp_quantity ,sp_color ,sp_describes, category_id from sanpham where sp_name = ?";
    private static final String CHECK_NAME_EXISTS = "SELECT * FROM sanpham where sp_name = ?";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<Product> selectAllProduct() {
        List<Product> productsList = new ArrayList<>();
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("sp_name");
                int price = rs.getInt("sp_price");
                int quantity = rs.getInt("sp_quantity");
                String color = rs.getString("sp_color");
                String describes = rs.getString("sp_describes");
                int category_id = rs.getInt("category_id");
               Product products = new Product(id,name,price,quantity,color,describes,category_id);
                productsList.add(products);
            }
        }catch (SQLException ex){
            printSQLException(ex);
        }
        return productsList;
    }

    @Override
    public Product selectProductById(int id) {
        try {
            conn = getConnection();
            ps=conn.prepareStatement(SELECT_PRODUCT_BY_ID);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                id = rs.getInt("id");
                String name = rs.getString("sp_name");
                int price = rs.getInt("sp_price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("sp_color");
                String describes = rs.getString("sp_describes");
                int category = rs.getInt("category_id");
                Product products = new Product(id,name,price,quantity,color, describes,category);
                return products ;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void insertProduct(String name, int price, int quantity, String color, String describes, int category_id) throws SQLException {
        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT_PRODUCT);
            ps.setString(1,name);
            ps.setInt(2, price);
            ps.setInt(3, quantity);
            ps.setString(4, describes);
            ps.setInt(5, category_id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted;
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT)) {
            System.out.println( getClass()+  " deleteProduct " +statement);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean editProducts(Product products) throws SQLException {
        boolean rowUpdated;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_PRODUCT);
            ps.setString(1, products.getName());
            ps.setInt(2, products.getPrice());
            ps.setInt(3, products.getQuantity());
            ps.setString(4, products.getColor());
            ps.setString(5, products.getDescribes());
            ps.setInt(6,products.getCategory_id());
            ps.setInt(7, products.getId());
            rowUpdated = ps.executeUpdate() > 0;
            return rowUpdated;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return false;
    }

    @Override
    public List<Product> searchByName(String txtSearch) {
//        List<Product> list = new ArrayList<>();
//        try {
//            conn = getConnection();
//            ps = conn.prepareStatement(SEARCH_PRODUCT_BY_NAME);
//            ps.setString(1, "%" + txtSearch + "%");
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                list.add(new Product(rs.getInt(1),
//                        rs.getString(2),
//                        rs.getInt(3),
//                        rs.getInt(4),
//                        rs.getString(5),
//                        rs.getInt(6)));
//            }
//        } catch (Exception e) {
//        }
//        return list;
        return null;
    }

    @Override
    public boolean checkNameExits(String name) {
        try {
            conn = getConnection();
            ps = conn.prepareStatement(CHECK_NAME_EXISTS);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        }catch (SQLException ex) {
        }
        return false;
    }
}
