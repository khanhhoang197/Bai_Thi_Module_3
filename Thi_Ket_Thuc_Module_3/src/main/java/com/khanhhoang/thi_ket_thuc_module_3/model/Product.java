package com.khanhhoang.thi_ket_thuc_module_3.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Product {
    private  int id;
    private String name;
    private int price;
    private int quantity;
    private String color;
    private  String describes;
    private int category_id;


    public Product(int id, String name, int price, int quantity, String color, String describes, int category_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.describes = describes;
        this.category_id = category_id;
    }

    public Product() {

    }

    public Product(String name, int price, int quantity, String color, String describes, int category_id) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.describes = describes;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @NotEmpty(message = "Hình ảnh không được để trống")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Min(100000)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Min(1)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", color='" + color + '\'' +
                ", category_id=" + category_id +
                '}';
    }
}
