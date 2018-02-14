/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cachedstorebdgui.views;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Daniel
 */
public class ProductDetailsPanel extends JPanel {

    private JLabel idLabel;
    private JLabel codeLabel;
    private JLabel descLabel;
    private JLabel priceLabel;
    private JLabel stockLabel;

    private JTextField idField;
    private JTextField codeField;
    private JTextField descField;
    private JTextField priceField;
    private JTextField stockField;

    public ProductDetailsPanel() {
        initComponents();
    }

    private void initComponents() {

        idLabel = new JLabel("ID: ");
        codeLabel = new JLabel("CODE: ");
        descLabel = new JLabel("DESCRIPTION: ");
        priceLabel = new JLabel("PRICE:");
        stockLabel = new JLabel("STOCK: ");

        idField = new JTextField("");
        codeField = new JTextField("");
        descField = new JTextField("");
        priceField = new JTextField("");
        stockField = new JTextField("");

        setLayout(new GridLayout(6, 0));
        add(idLabel);
        add(idField);
        add(codeLabel);
        add(codeField);
        add(descLabel);
        add(descField);
        add(priceLabel);
        add(priceField);
        add(stockLabel);
        add(stockField);
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(JLabel idLabel) {
        this.idLabel = idLabel;
    }

    public JLabel getCodeLabel() {
        return codeLabel;
    }

    public void setCodeLabel(JLabel codeLabel) {
        this.codeLabel = codeLabel;
    }

    public JLabel getDescLabel() {
        return descLabel;
    }

    public void setDescLabel(JLabel descLabel) {
        this.descLabel = descLabel;
    }

    public JLabel getPriceLabel() {
        return priceLabel;
    }

    public void setPriceLabel(JLabel priceLabel) {
        this.priceLabel = priceLabel;
    }

    public JLabel getStockLabel() {
        return stockLabel;
    }

    public void setStockLabel(JLabel stockLabel) {
        this.stockLabel = stockLabel;
    }

    public JTextField getIdField() {
        return idField;
    }

    public void setIdField(String idField) {
        this.idField.setText(idField);
    }

    public JTextField getCodeField() {
        return codeField;
    }

    public void setCodeField(String codeField) {
        this.codeField.setText(codeField);
    }

    public JTextField getDescField() {
        return descField;
    }

    public void setDescField(String descField) {
        this.descField.setText(descField);
    }

    public JTextField getPriceField() {
        return priceField;
    }

    public void setPriceField(String priceField) {
        this.priceField.setText(priceField);
    }

    public JTextField getStockField() {
        return stockField;
    }

    public void setStockField(String stockField) {
        this.stockField.setText(stockField);
    }

}
