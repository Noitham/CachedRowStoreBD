/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cachedstorebdgui.model;

import cachedstorebdgui.persist.SQLInterface;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dmora
 */
public class Store {

    private ArrayList<Product> products; //List of products

    //costructor
    public Store() {
        this.products = new ArrayList<>();
    }

    //accesors
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * Gets number of products
     *
     * @return products.size()
     */
    public int getNumProducts() {
        return products.size();
    }

    /**
     * Gets element of position index
     *
     * @param index position of element to retrieve
     * @return element at position index or null if not exists.
     */
    public Product get(int index) {

        return products.get(index);

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

    /**
     * Makes a query which will return our products from database.
     *
     * @return products list
     */
    public List<Product> getAllProducts() {

        // create SQLInterface object
        SQLInterface iface = new SQLInterface("storeusr", "storepsw");

        // Execute query
        if (!iface.execQuery("SELECT * FROM products")) {
            System.exit(1);
        }
        // create CachedRowSet and output
        // data to terminal
        try {
            CachedRowSetImpl crs = new CachedRowSetImpl();
            crs = iface.getRowSet();

            while (crs.next()) {

                System.out.println("ID:" + crs.getString(1)
                        + ", CODE: " + crs.getString(2)
                        + ", NAME:" + crs.getString(3)
                        + ", PRICE: " + crs.getString(4)
                        + ", STOCK: " + crs.getString(5));

                String id, code, name, price, stock;

                id = crs.getString(1);
                code = crs.getString(2);
                name = crs.getString(3);
                price = crs.getString(4);
                stock = crs.getString(5);

                Product p = (new Product(Long.parseLong(id), code, name, Double.parseDouble(price), Integer.parseInt(stock)));

                products.add(p);
            }

        } catch (SQLException se) {
            System.out.println(se.getMessage());
            products = null;
        }

        return products;
    }

}
