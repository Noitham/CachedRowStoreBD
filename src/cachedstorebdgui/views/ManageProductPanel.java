/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cachedstorebdgui.views;

import cachedstorebdgui.controllers.Controller;
import cachedstorebdgui.model.Store;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author alumne
 */
public class ManageProductPanel extends JPanel {

    private ProductDetailsPanel detailsPanel;
    private ButtonsPanel buttonsPanel;

    private final Controller controller;
    private final ActionListener al;

    public ManageProductPanel(Controller controller, ActionListener al) {
        this.al = al;
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {

        setLayout(new BorderLayout());

        detailsPanel = new ProductDetailsPanel();
        buttonsPanel = new ButtonsPanel(al);

        add(detailsPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    public ProductDetailsPanel getDetailsPanel() {
        return detailsPanel;
    }

    public void setDetailsPanel(ProductDetailsPanel detailsPanel) {
        this.detailsPanel = detailsPanel;
    }

}
