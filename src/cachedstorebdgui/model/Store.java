/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cachedstorebdgui.model;

import java.util.ArrayList;

/**
 * @author dmora
 */
public class Store {

    private final ArrayList<Product> products; //List of products

    //costructor
    public Store() {
        this.products = new ArrayList<>();
    }

    //accesors
    public ArrayList<Product> getProducts() {
        return products;
    }

    public int getNumProducts() {
        return products.size();
    }

    //methods
    //add new product
    //modify a product
    //delete a product
    //find a product
    /**
     * Gets element of position Index
     *
     * @param index position of element to retrieve
     * @return element at position index or null if not exists.
     */
    public Product get(int index) {

        return products.get(index);

    }

    /**
     * Adds a new product to the store It prevents writing if list is full. It
     * avoids duplicates
     *
     * @param product to add.
     * @return true if product has been successfully added false otherwise
     */
    public boolean add(Product product) {

        return false;
    }

    /**
     * Search p in the list.
     *
     * @param p is the product to find
     * @return the product found or null if not found.
     */
    public Product find(Product p) {

        Product found = null;

        ArrayList<Product> originalData = retrieveData();

        for (int i = 0; i < originalData.size() - 1; i++) {
            if (originalData.get(i).equals(p)) {
                found = originalData.get(i);
                break;
            }
        }

        return found;

    }

    /**
     * Search p in the list.
     *
     * @param code is the product to find
     */
    public void searchByCode(String code) {

        ArrayList<Product> originalData = retrieveData();

        for (int i = 0; i < originalData.size() - 1; i++) {
            if (originalData.get(i).getCode().equals(code)) {
                products.add(originalData.get(i));
            }
        }

    }

    /**
     * Search products with the given price.
     *
     * @param price to find
     */
    public void findByPrice(double price) {

        ArrayList<Product> originalData = retrieveData();

        for (int i = 0; i < originalData.size() - 1; i++) {
            if (originalData.get(i).getPrice() == price) {
                products.add(originalData.get(i));
            }
        }
    }

    /**
     * removes a product from the store
     *
     * @param product to remove
     * @return true if product has been removed, false otherwise.
     */
    public boolean remove(Product product) {

        ArrayList<Product> originalData = retrieveData();

        boolean b = false;
        if (product != null) {
            b = products.remove(originalData);
        }
        return b;
    }

    /**
     * searches a product and gives its position
     *
     * @param product to search
     * @return position of product or -1 if not found.
     */
    public int indexOf(Product product) {

        return products.indexOf(product);
    }

    public void modify(Product product, String code, String name, double price) {

        if (product != null) {
            product.setCode(code);
            product.setName(name);
            product.setPrice(price);
        }

    }

    public ArrayList<Product> retrieveData() {
        ArrayList<Product> originalData = new ArrayList<>();

        originalData.add(new Product("aaa", "aaa", 111, 3));
        originalData.add(new Product("bbb", "bbb", 222, 1));
        originalData.add(new Product("ccc", "ccc", 333, 5));
        originalData.add(new Product("ddd", "ddd", 444, 9));

        return originalData;
    }

    public void loadData() {
        products.addAll(retrieveData());
    }

    public void clearData() {
        products.clear();
    }

}
