package com.khanhhoang.thi_ket_thuc_module_3.DAO;

import com.khanhhoang.thi_ket_thuc_module_3.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends DatabaseQuery implements ICategory{


    private static final String INSERT_CATEGORY_SQL = "INSERT INTO category (category_name) VALUES (?);";
    private static final String SELECT_CATEGORY_BY_ID = "select * from  category where category_id =?";
    private static final String SELECT_ALL_CATEGORY = "select * from category";
    private static final String DELETE_CATEGORY_SQL = "delete from category where category_id = ?;";
    private static final String UPDATE_CATEGORY_SQL = "update category set category_name = ? where category_id = ?;";

    @Override
    public void insertCategory(Category category) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY_SQL)) {
            preparedStatement.setString(1, category.getCategory_name());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Category selectCategory(int id) {
        Category category = null;

        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("getCategory_name");

                category = new Category(id, name  );
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return category;
    }

    @Override
    public List<Category> selectAllCategory() {
        List<Category> category = new ArrayList<>();
        try ( Connection connection = getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("category_id");
                String name = rs.getString("category_name");

                category.add(new Category(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return category;
    }

    @Override
    public boolean updateCategory(Category category) throws SQLException {
        boolean rowUpdated;

        try ( Connection connection = getConnection();
              PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY_SQL);) {
            statement.setInt(1, category.getCategory_id());
            statement.setString(2, category.getCategory_name());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteCategory(int id) throws SQLException {
        boolean rowDeleted;

        try ( Connection connection = getConnection();
              PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

}
