package com.example.myshopping.bean;

import java.util.Objects;

public class Information {
    int imageViewID;
    String name;
    String price;
    int count;


    public Information(int imageViewID, String name, String price,int count) {
        this.imageViewID = imageViewID;
        this.name = name;
        this.price = price;
        this.count=count;
    }

    public int getImageViewID() {
        return imageViewID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setImageViewID(int imageViewID) {
        this.imageViewID = imageViewID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Information that = (Information) o;
        return imageViewID == that.imageViewID &&
                count == that.count &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageViewID, name, price, count);
    }
}
