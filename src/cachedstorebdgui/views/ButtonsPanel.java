/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cachedstorebdgui.views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author dmora
 */
class ButtonsPanel extends JPanel {

    private final ActionListener al;

    private JButton startButton;
    private JButton previusButton;
    private JButton nextButton;
    private JButton endButton;
    private JButton insertButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton clearButton;

    public ButtonsPanel(ActionListener al) {
        this.al = al;
        initComponents();
    }

    private void initComponents() {

        startButton = new JButton("<<");
        startButton.setActionCommand("gostart");
        startButton.addActionListener(al);
        previusButton = new JButton("<");
        previusButton.setActionCommand("goprev");
        previusButton.addActionListener(al);
        nextButton = new JButton(">");
        nextButton.setActionCommand("gonext");
        nextButton.addActionListener(al);
        endButton = new JButton(">>");
        endButton.setActionCommand("goend");
        endButton.addActionListener(al);
        insertButton = new JButton("INS");
        insertButton.setActionCommand("insert");
        insertButton.addActionListener(al);
        updateButton = new JButton("UPD");
        updateButton.setActionCommand("update");
        updateButton.addActionListener(al);
        deleteButton = new JButton("DEL");
        deleteButton.setActionCommand("delete");
        deleteButton.addActionListener(al);
        clearButton = new JButton("CLR");
        clearButton.setActionCommand("clear");
        clearButton.addActionListener(al);

        setLayout(new GridLayout(1, 8));
        add(startButton);
        add(previusButton);
        add(nextButton);
        add(endButton);
        add(insertButton);
        add(updateButton);
        add(deleteButton);
        add(clearButton);

    }

}
