/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cachedstorebdgui.controllers;

import cachedstorebdgui.model.Product;
import cachedstorebdgui.model.Store;
import cachedstorebdgui.persist.SQLInterface;
import cachedstorebdgui.views.ProductDetailsPanel;
import cachedstorebdgui.views.StoreMainFrame;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.SQLException;
import java.util.List;

/**
 * @author alumne
 */
public class Controller {

    private final Store model;
    private StoreMainFrame view;
    ProductDetailsPanel details;

    public Controller(Store model) {
        this.model = model;
        Controller controller = this;
        javax.swing.SwingUtilities.invokeLater(() -> {
            controller.view = new StoreMainFrame(controller, model);
        });
    }

    public void loadData() {
        model.clearData();
        model.loadData();
    }

    public void clear() {
        model.clearData();
    }

    public List<Product> getAllProducts(List<Product> data) {
        // create SQLInterface object
        SQLInterface iface = new SQLInterface("storeusr", "storepsw");
        // execute query
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

                data.add(p);
            }

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }

        return data;
    }

    public void searchByCode(String code) {

        clear();

        if (code != null) {
            model.searchByCode(code);

            if (model.getProducts().size() > 0) {
                view.displayProductTable(model.getProducts());
            } else {//Product is null
                System.out.println("product not found");
            }
        } else {
            System.out.println("errror readingcode");
        }

    }

    public void searchByPrice(double price) {

        clear();

        model.findByPrice(price);

        if (model.getProducts().size() > 0) {
            view.displayProductTable(model.getProducts());
        } else {//Product is null
            System.out.println("product not found");
        }

    }

    public void remove() {

        String code = "aaa";

        if (code != null) {
            //Search the product
            Product p = new Product(code);
            Product product = model.find(p);
            if (p != null) {

                boolean b;
                if (b = true) {
                    model.remove(product);
                    System.out.println("productdeleted");
                } else {
                    System.out.println("productnotdeleted");
                }

            } else {//Product is null
                System.out.println("productnotfound");
            }
        } else {
            System.out.println("errorreadingcode");
        }

    }

}
