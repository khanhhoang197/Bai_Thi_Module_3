package com.khanhhoang.thi_ket_thuc_module_3.DAO;

import com.khanhhoang.thi_ket_thuc_module_3.model.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategory {
    public void insertCategory(Category category) throws SQLException;

    public Category selectCategory(int category_id);

    public List<Category> selectAllCategory();

    public boolean updateCategory(Category category) throws SQLException;

    boolean deleteCategory(int category_id) throws SQLException;
}