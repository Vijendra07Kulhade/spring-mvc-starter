package com.kulhade.entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

/**
 * Created by vk250236 on 4/11/17.
 */
public class Product {

    private long id;

    private String product_Name;

    private String descripction;

    private Category category;

    private String price;

    private Date mfg_Date;


    private MultipartFile image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public String getDescripction() {
        return descripction;
    }

    public void setDescripction(String descripction) {
        this.descripction = descripction;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getMfg_Date() {
        return mfg_Date;
    }

    public void setMfg_Date(Date mfg_Date) {
        this.mfg_Date = mfg_Date;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product_Name='" + product_Name + '\'' +
                ", descripction='" + descripction + '\'' +
                ", category=" + category +
                ", price='" + price + '\'' +
                '}';
    }

    private static class Category{
        long category_id;
        String category_name;

        public long getCategory_id() {
            return category_id;
        }

        public void setCategory_id(long category_id) {
            this.category_id = category_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }
    }
}
