/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cachedstorebdgui;

import cachedstorebdgui.controllers.Controller;
import cachedstorebdgui.model.Store;

/**
 * @author dmora
 */
public class CachedStoreBDGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            Store model = new Store();
            Controller controller;
            controller = new Controller(model);
        });
    }

}
