/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cachedstorebdgui.views;

import cachedstorebdgui.controllers.Controller;
import cachedstorebdgui.model.Product;
import cachedstorebdgui.model.Store;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * @author alumne
 */
public class StoreMainFrame extends JFrame implements ActionListener {

    private final Store model;
    private final Controller controller;

    private WelcomePanel welcomePanel;
    private ManageProductPanel managePanel;
    private ProductDetailsPanel detailsPanel;

    private final String aboutMessage;

    List<Product> myProducts = new ArrayList<>();

    public StoreMainFrame(Controller controller, Store model) {
        this.controller = controller;
        this.model = model;
        aboutMessage = "<html><p>CachedStore GUI Application</p><p>(c) DanielSoft 2017</p></html>";
        //We load our product list
        controller.getAllProducts(myProducts);
        initComponents();
    }

    private void initComponents() {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Cached JTable Store");

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                exitApplication();
            }
        });

        JMenuBar menuBar = buildMenuBar();
        setJMenuBar(menuBar);

        Container pane = this.getContentPane();
        pane.setLayout(new BorderLayout());
        welcomePanel = new WelcomePanel(this);
        pane.add(welcomePanel, BorderLayout.CENTER);

        this.setLocationRelativeTo(null);
        setSize(700, 600);
        setVisible(true);
    }

    private JMenuBar buildMenuBar() {

        JMenuBar menuBar = new JMenuBar();
        JMenu menu;
        JMenuItem item;

        menu = new JMenu("File");
        item = new JMenuItem("Exit");
        item.setActionCommand("exit");
        item.addActionListener(this);
        menu.add(item);
        menuBar.add(menu);

        menu = new JMenu("Edit");
        item = new JMenuItem("Manage");
        item.setActionCommand("listall");
        item.addActionListener(this);
        menu.add(item);
        menuBar.add(menu);

        menu = new JMenu("Help");
        item = new JMenuItem("About");
        item.setActionCommand("about");
        item.addActionListener(this);
        menu.add(item);
        menuBar.add(menu);

        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        processAction(action);
        System.out.println("Executting action: " + action);
    }

    private void processAction(String action) {
        if (action != null) {
            switch (action) {
                case "exit":
                    // Exit
                    exitApplication();
                    break;
                case "launchapp":
                    // Shows values panel
                    setManagePanel();
                    break;
                case "about":
                    // About
                    aboutDialogue();
                    break;
                case "gostart":
                    loadData();
                    break;
                case "clear":
                    controller.clear();
                    break;
                case "delete":
                    controller.remove();
                    break;
                default:
                    break;
            }
            System.out.println("Execution action: " + action);
        }
    }

    /**
     * Asks for confirmation and exits application
     */
    public void exitApplication() {
        int choice = JOptionPane.showConfirmDialog(this, "Would you like to close the application");
        if (choice == JOptionPane.OK_OPTION) {
            System.exit(0);
        } else if (choice == JOptionPane.OK_CANCEL_OPTION) {

        }
        System.out.println("Exitting app");
    }

    /**
     * Shows aboutDialogue
     */
    public void aboutDialogue() {
        JOptionPane.showMessageDialog(this, aboutMessage);
    }

    public void setManagePanel() {

        Container pane = this.getContentPane();
        pane.setLayout(new BorderLayout());
        managePanel = new ManageProductPanel(model, controller, this);
        pane.add(managePanel, BorderLayout.CENTER);

        this.setContentPane(managePanel);
        this.validate();
    }

    private void loadData() {

        for (int i = 1; i < myProducts.size(); i++) {
            for (Product p : myProducts) {
                detailsPanel.setIdField(String.valueOf(p.getId()));
                detailsPanel.setCodeField(p.getCode());
                detailsPanel.setDescField(p.getName());
                detailsPanel.setPriceField(String.valueOf(p.getPrice()));
                detailsPanel.setStockField(String.valueOf(p.getStock()));
            }
        }

    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public String displayInputDialog(String message) {
        return JOptionPane.showInputDialog(this, message);
    }

    public void displayProductTable(List<Product> data) {
        for (Product product : data) {
            System.out.println(product.toString());
        }
        System.out.println(data.size() + " products found");

    }

}
