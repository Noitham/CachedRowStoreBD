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

    private Store model;
    private Controller controller;

    private WelcomePanel welcomePanel;
    private ManageProductPanel managePanel;

    private final String aboutMessage;

    private List<Product> myProducts;

    private int i = 0;

    public StoreMainFrame(Controller controller, Store model) {
        this.controller = controller;
        this.model = model;
        aboutMessage = "<html><p>CachedStore GUI Application</p><p>(c) DanielSoft 2017</p></html>";
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
                    loadData();
                    break;
                case "listall":
                    // Shows values panel
                    listProducts();
                    break;
                case "gonext":
                    // Next
                    nextProduct();
                    break;
                case "goprev":
                    // Next
                    previousProduct();
                    break;
                case "gostart":
                    firstProduct();
                    break;
                case "goend":
                    lastProduct();
                    break;
                case "about":
                    // About
                    aboutDialogue();
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

    /**
     * Sets manage panel
     */
    public void setManagePanel() {

        Container pane = this.getContentPane();
        pane.setLayout(new BorderLayout());
        managePanel = new ManageProductPanel(controller, this);
        pane.add(managePanel, BorderLayout.CENTER);

        this.setContentPane(managePanel);
        this.validate();
    }

    /**
     * Calls controller methis listArticles, which will load our database
     * products
     */
    private void loadData() {

        myProducts = controller.listArticles();

    }

    /**
     * We list the loaded products in our panel
     */
    private void listProducts() {

        managePanel.getDetailsPanel().setIdField(String.valueOf(myProducts.get(0).getId()));
        managePanel.getDetailsPanel().setCodeField(myProducts.get(0).getCode());
        managePanel.getDetailsPanel().setDescField(myProducts.get(0).getName());
        managePanel.getDetailsPanel().setPriceField(String.valueOf(myProducts.get(0).getPrice()));
        managePanel.getDetailsPanel().setStockField(String.valueOf(myProducts.get(0).getStock()));

    }

    /**
     * Changes the shown product to the next one
     */
    private void nextProduct() {

        i = i + 1;
        try {
            managePanel.getDetailsPanel().setIdField(String.valueOf(myProducts.get(i).getId()));
            managePanel.getDetailsPanel().setCodeField(myProducts.get(i).getCode());
            managePanel.getDetailsPanel().setDescField(myProducts.get(i).getName());
            managePanel.getDetailsPanel().setPriceField(String.valueOf(myProducts.get(i).getPrice()));
            managePanel.getDetailsPanel().setStockField(String.valueOf(myProducts.get(i).getStock()));

        } catch (IndexOutOfBoundsException ex) {
            i = myProducts.size() - 1;
            managePanel.getDetailsPanel().setIdField(String.valueOf(myProducts.get(i).getId()));
            managePanel.getDetailsPanel().setCodeField(myProducts.get(i).getCode());
            managePanel.getDetailsPanel().setDescField(myProducts.get(i).getName());
            managePanel.getDetailsPanel().setPriceField(String.valueOf(myProducts.get(i).getPrice()));
            managePanel.getDetailsPanel().setStockField(String.valueOf(myProducts.get(i).getStock()));

        }

    }

    /**
     * Changes the shown product to the previous
     */
    private void previousProduct() {

        i = i - 1;
        try {

            managePanel.getDetailsPanel().setIdField(String.valueOf(myProducts.get(i).getId()));
            managePanel.getDetailsPanel().setCodeField(myProducts.get(i).getCode());
            managePanel.getDetailsPanel().setDescField(myProducts.get(i).getName());
            managePanel.getDetailsPanel().setPriceField(String.valueOf(myProducts.get(i).getPrice()));
            managePanel.getDetailsPanel().setStockField(String.valueOf(myProducts.get(i).getStock()));

        } catch (IndexOutOfBoundsException ex) {
            i = i + 1;
            managePanel.getDetailsPanel().setIdField(String.valueOf(myProducts.get(i).getId()));
            managePanel.getDetailsPanel().setCodeField(myProducts.get(i).getCode());
            managePanel.getDetailsPanel().setDescField(myProducts.get(i).getName());
            managePanel.getDetailsPanel().setPriceField(String.valueOf(myProducts.get(i).getPrice()));
            managePanel.getDetailsPanel().setStockField(String.valueOf(myProducts.get(i).getStock()));

        }

    }

    private void firstProduct() {

        managePanel.getDetailsPanel().setIdField(String.valueOf(myProducts.get(0).getId()));
        managePanel.getDetailsPanel().setCodeField(myProducts.get(0).getCode());
        managePanel.getDetailsPanel().setDescField(myProducts.get(0).getName());
        managePanel.getDetailsPanel().setPriceField(String.valueOf(myProducts.get(0).getPrice()));
        managePanel.getDetailsPanel().setStockField(String.valueOf(myProducts.get(0).getStock()));

    }

    private void lastProduct() {

        int size = myProducts.size() - 1;

        managePanel.getDetailsPanel().setIdField(String.valueOf(myProducts.get(size).getId()));
        managePanel.getDetailsPanel().setCodeField(myProducts.get(size).getCode());
        managePanel.getDetailsPanel().setDescField(myProducts.get(size).getName());
        managePanel.getDetailsPanel().setPriceField(String.valueOf(myProducts.get(size).getPrice()));
        managePanel.getDetailsPanel().setStockField(String.valueOf(myProducts.get(size).getStock()));

    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public String displayInputDialog(String message) {
        return JOptionPane.showInputDialog(this, message);
    }

}
