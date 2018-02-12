/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cachedstorebdgui.model;

import java.util.Objects;

/**
 * @author dmora
 */
public class Product {

    //attributes
    private long id;
    private String code;
    private String name;
    private double price;
    int stock;

    //constructors
    public Product(long id) {
        this.id = id;
    }

    public Product(long id, String code, String name, double price, int stock) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product(String code, String name, double price, int stock) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product(String code) {
        this.code = code;
    }

    public Product() {

    }

    public Product(Product other) {
        this.code = other.code;
        this.name = other.name;
        this.price = other.price;
        this.stock = other.stock;
    }

    //accessors
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //methods
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.code);
        return hash;
    }

    /**
     * Compare product with another one Two products are equal if their codes
     * are equals
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {

        boolean b = false;

        if (obj == null) {//null object

            b = false;
        } else {

            if (obj == this) {//same object

                b = true;
            } else {

                if (obj instanceof Product) { //obj is product

                    Product other = (Product) obj;
                    b = (this.code.equals(other.code));

                } else { //obj is not a product

                    b = false;

                }

            }
        }

        return b;
    }

    @Override
    public String toString() {
        //return "Product{" + "code=" + code + ", name=" + name + ", price=" + price + '}';
        StringBuilder sb = new StringBuilder();
        sb.append("product" + "{");
        sb.append("id" + "=");
        sb.append(id);
        sb.append(", " + "code" + "=");
        sb.append(code);
        sb.append(", " + "name" + "=");
        sb.append(name);
        sb.append(", " + "price" + "=");
        sb.append(price);
        sb.append(", " + "stock" + "=");
        sb.append(stock);
        sb.append("}");

        return sb.toString();
    }

}
