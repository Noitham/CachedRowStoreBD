/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cachedstorebdgui.controllers;

import cachedstorebdgui.model.Product;
import cachedstorebdgui.model.Store;
import cachedstorebdgui.views.StoreMainFrame;
import java.util.List;

/**
 * @author alumne
 */
public class Controller {

    private final Store model;
    private StoreMainFrame view;

    public Controller(Store model) {
        this.model = model;
        Controller controller = this;
        javax.swing.SwingUtilities.invokeLater(() -> {
            controller.view = new StoreMainFrame(controller, model);
        });
    }

    /**
     * Method for calling model action getAllProducts, will return the product list.
     * @return a list of products loaded from database.
     */
    public List<Product> listArticles() {
        return model.getAllProducts();
    }

}
